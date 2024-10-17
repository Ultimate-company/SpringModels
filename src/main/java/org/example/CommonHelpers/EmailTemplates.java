package org.example.CommonHelpers;

import org.example.Models.RequestModels.SendEmailRequest;
import org.example.Models.ResponseModels.Response;

import java.util.ArrayList;
import java.util.List;

public class EmailTemplates {
    private final EmailHelper emailHelper;
    public EmailTemplates(String senderName, String fromAddress, String sendgridApiKey) {
        this.emailHelper = new EmailHelper(senderName, fromAddress, sendgridApiKey);
    }

    public Response<Boolean> sendNewUserAccountConfirmation(long userId, String userToken, String userEmail, String temporaryPassword) {
        // Generate the confirmation account link
        String confirmAccountLink =
                "https://localhost:6001/dashboard/ConfirmEmail?UserId=" + userId + "&Token=" + java.net.URLEncoder.encode(userToken, java.nio.charset.StandardCharsets.UTF_8);

        // Create the email template and plain text content
        String emailTemplate =
                "<p>Please Click on the Link below to confirm your Email account</p><br/><a href='" + confirmAccountLink + "'>" + confirmAccountLink + "</a>" +
                        "<br/><br/><p>Your temporary password is: "+temporaryPassword+"</p>";

        String plainText = "Please Click on the Link below to confirm your Email account \n" +
                confirmAccountLink;

        // Create a SendEmailRequest object with the necessary details
        SendEmailRequest sendEmailRequest = new SendEmailRequest();
        sendEmailRequest.setToAddress(List.of(userEmail));
        sendEmailRequest.setSubject("Account Confirmation with temporary password");
        sendEmailRequest.setHtmlContent(emailTemplate);
        sendEmailRequest.setPlainTextContent(plainText);

        // Send the account confirmation email using the email helper
        return emailHelper.sendEmail(sendEmailRequest);
    }

    /**
     * Sends an account confirmation email to the specified user.
     * @param userId The ID of the user.
     * @param userToken The token associated with the user.
     * @param userEmail The email address of the user.
     * @return A response indicating the success status and message.
     */
    public Response<Boolean> sendAccountConfirmationEmail(long userId, String userToken, String userEmail) {
        // Generate the confirmation account link
        String confirmAccountLink =
                "https://localhost:6001/dashboard/ConfirmEmail?UserId=" + userId + "&Token=" + java.net.URLEncoder.encode(userToken, java.nio.charset.StandardCharsets.UTF_8);

        // Create the email template and plain text content
        String emailTemplate =
                "<p>Please Click on the Link below to confirm your Email account</p><br/><a href='" + confirmAccountLink + "'>" + confirmAccountLink + "</a>";
        String plainText = "Please Click on the Link below to confirm your Email account \n" +
                confirmAccountLink;

        // Create a SendEmailRequest object with the necessary details
        SendEmailRequest sendEmailRequest = new SendEmailRequest();
        sendEmailRequest.setToAddress(List.of(userEmail));
        sendEmailRequest.setSubject("Account Confirmation");
        sendEmailRequest.setHtmlContent(emailTemplate);
        sendEmailRequest.setPlainTextContent(plainText);

        // Send the account confirmation email using the email helper
        return emailHelper.sendEmail(sendEmailRequest);
    }

    /**
     * Sends a password reset email to the specified email address.
     *
     * @param email    The email address of the recipient.
     * @param password The new password for the user.
     * @return A response indicating the success status and message.
     */
    public Response<Boolean> sendResetPasswordEmail(String email, String password) {
        // Create a SendEmailRequest object with the necessary details
        SendEmailRequest sendEmailRequest = new SendEmailRequest();
        sendEmailRequest.setSubject("Password Reset");
        List<String> toAddresses = new ArrayList<>();
        toAddresses.add(email);
        sendEmailRequest.setToAddress(toAddresses);
        sendEmailRequest.setPlainTextContent("Your New password is: " + password);
        sendEmailRequest.setHtmlContent("<html>" +
                "<body>" +
                "<div>" +
                "<h3> Your new Password is : " + password + " </h3>" +
                "</div>" +
                "</body>" +
                "</html>");

        // Send the reset password email using the email helper
        return emailHelper.sendEmail(sendEmailRequest);
    }
}
