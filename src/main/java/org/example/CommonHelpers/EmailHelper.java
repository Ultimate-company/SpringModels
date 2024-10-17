package org.example.CommonHelpers;

import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Base64;
import java.util.Collection;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Attachments;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import org.example.Models.RequestModels.SendEmailRequest;
import org.example.Models.ResponseModels.Response;
import java.io.IOException;


public class EmailHelper {
    private final String fromAddress;
    private final String senderName;
    private final String sendGridApiKey;
    public EmailHelper(String fromAddress, String senderName, String sendgridApiKey){
        this.fromAddress = fromAddress;
        this.senderName = senderName;
        this.sendGridApiKey = sendgridApiKey;
    }

    /**
     * Generates a meeting request string in iCalendar format.
     *
     * @param from       The email address of the meeting organizer.
     * @param toUsers    A collection of email addresses of the meeting attendees.
     * @param subject    The subject of the meeting request.
     * @param desc       The description of the meeting request.
     * @param startTime  The start time of the meeting.
     * @param endTime    The end time of the meeting.
     * @param isCancel   Specifies whether the meeting request is a cancellation request. Default is false.
     * @return A string representing the meeting request in iCalendar format.
     */
    private String meetingRequestString(String from, Collection<String> toUsers, String subject,
                                        String desc, LocalDateTime startTime, LocalDateTime endTime, boolean isCancel) {
        return "BEGIN:VCALENDAR\n" +
                "PRODID:-//Microsoft Corporation//Outlook 12.0 MIMEDIR//EN\n" +
                "VERSION:2.0\n" +
                String.format("METHOD:%s\n", isCancel ? "CANCEL" : "REQUEST") +
                "BEGIN:VEVENT\n" +
                String.format("DTSTART:%s\n", startTime.atZone(ZoneId.systemDefault()).toInstant().toString()) +
                String.format("DTSTAMP:%s\n", LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toString()) +
                String.format("DTEND:%s\n", endTime.atZone(ZoneId.systemDefault()).toInstant().toString()) +
                String.format("DESCRIPTION:%s\n", desc.replace("\n", "<br>")) +
                String.format("X-ALT-DESC;FMTTYPE=text/html:%s\n", desc.replace("\n", "<br>")) +
                String.format("SUMMARY:%s\n", subject) +
                String.format("ORGANIZER;CN=\"%s\":MAILTO:%s\n", from, from) +
                String.format(
                        "ATTENDEE;CUTYPE=INDIVIDUAL;ROLE=REQ-PARTICIPANT;PARTSTAT=NEEDS-ACTION;CN=\"%s\";RSVP=TRUE:mailto:%s\n",
                        String.join(",", toUsers), String.join(",", toUsers)) +
                "BEGIN:VALARM\n" +
                "TRIGGER:-PT15M\n" +
                "ACTION:DISPLAY\n" +
                "DESCRIPTION:Reminder\n" +
                "END:VALARM\n" +
                "END:VEVENT\n" +
                "END:VCALENDAR\n";
    }

    public Response<Boolean> sendEmail(SendEmailRequest request) {
        SendGrid sendGridClient = new SendGrid(sendGridApiKey);

        // form the sendgrid mail
        Mail mail = new Mail();
        Personalization personalization = new Personalization();
        personalization.addTo(new Email(request.getToAddress().getFirst()));
        mail.addPersonalization(personalization);
        mail.setFrom(new Email(fromAddress, senderName));
        mail.setSubject(request.getSubject());
        mail.addContent(new Content("text/plain", request.getPlainTextContent()));
        mail.addContent(new Content("text/html", request.getHtmlContent()));

        if (request.getSendAt() != null) {
            mail.setSendAt(request.getSendAt().toEpochSecond(ZoneOffset.UTC));

            try {
                // Check if the batch ID is valid
                Request httpRequest = new Request();
                httpRequest.setMethod(Method.GET);
                httpRequest.setEndpoint("mail/batch/" + request.getBatchId());
                com.sendgrid.Response response = sendGridClient.api(httpRequest);

                int statusCode = response.getStatusCode();
                if (statusCode <= 200 || statusCode > 300) {
                    return new Response<Boolean>(false, "Invalid Batch Id", false);
                }
                mail.setBatchId(request.getBatchId());
            }
            catch (IOException e){
                return new Response<>(false, e.getMessage(), false);
            }
        }

        if (request.isInvite()) {
            String calendarContent = meetingRequestString(senderName, request.getAttendees(), request.getSubject(),
                    request.getPlainTextContent(), request.getMeetingDate(), request.getMeetingDate().plusHours(1), false);

            byte[] calendarBytes = calendarContent.getBytes(StandardCharsets.UTF_8);
            Attachments calendarAttachment = new Attachments();
            calendarAttachment.setFilename("invite.ics");
            calendarAttachment.setContent(Base64.getEncoder().encodeToString(calendarBytes));
            calendarAttachment.setType("text/calendar");
            mail.addAttachments(calendarAttachment);
        }

        try {
            Request httpRequest = new Request();
            httpRequest.setMethod(Method.POST);
            httpRequest.setEndpoint("mail/send");
            httpRequest.setBody(mail.build());
            com.sendgrid.Response sendGridResponse = sendGridClient.api(httpRequest);
            int code = sendGridResponse.getStatusCode();
            if (code >= 200 && code < 300) {
                return new Response<>(true, "Email Sent. It should arrive within 5 minutes.", true);
            }
            return new Response<>(false, sendGridResponse.getBody(), false);
        } catch (IOException e) {
            return new Response<>(false, e.getMessage(), false);
        }
    }

    /**
     * Generates a batch ID using the SendGrid API.
     *
     * @return A string representing the generated batch ID.
     */
    public Response<String> generateBatchId() {
        SendGrid sendGridClient = new SendGrid(this.sendGridApiKey);

        try{
            // Create a batch ID
            // POST /mail/batch
            Request httpRequest = new Request();
            httpRequest.setMethod(Method.POST);
            httpRequest.setEndpoint("mail/send");

            // Send a POST request to the SendGrid API to generate a batch ID
            com.sendgrid.Response sendGridResponse = sendGridClient.api(httpRequest);
            int code = sendGridResponse.getStatusCode();
            if (code >= 200 && code < 300) {
                return new Response<>(true, "Success", new ObjectMapper()
                        .readTree(sendGridResponse.getBody())
                        .get("batch_id").asText());
            }
            return new Response<>(false, sendGridResponse.getBody(), "Error");
        }
        catch (Exception e){
            return new Response<>(false, e.getMessage(), "Error");
        }
    }

    /**
     * Cancels a scheduled email batch using the SendGrid API.
     *
     * @param batchId The ID of the email batch to cancel.
     * @return True if the cancellation request is successful; otherwise, false.
     */
    public Response<Boolean> cancelEmail(String batchId) {
        SendGrid sendGridClient = new SendGrid(this.sendGridApiKey);

        // Define the request body for cancelling the email batch
        String body = """
                {
                    "batch_id": "%s",
                    "status": "cancel"
                }""".formatted(batchId);

        // Send a POST request to the SendGrid API to cancel the email batch
        try {
            // Set the request method and endpoint
            Request httpRequest = new Request();
            httpRequest.setMethod(Method.POST);
            httpRequest.setEndpoint("mail/scheduled_sends");

            // Set the request headers
            httpRequest.addHeader("Authorization", "Bearer " + this.sendGridApiKey);

            // Set the request body
            httpRequest.setBody(body);

            // Send the request
            com.sendgrid.Response sendGridResponse = sendGridClient.api(httpRequest);

            // Check the response status code
            int code = sendGridResponse.getStatusCode();
            if (code >= 200 && code < 300) {
                return new Response<>(true, "Success", true);
            }
            return new Response<>(false, sendGridResponse.getBody(), false);
        } catch (Exception e) {
            return new Response<>(false, e.getMessage(), false);
        }
    }
}
