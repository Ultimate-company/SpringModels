package org.example.CommonHelpers;

import com.sendgrid.helpers.mail.objects.Attachments;
import org.example.Models.CommunicationModels.CentralModels.Carrier;
import org.example.Models.CommunicationModels.CentralModels.GoogleCred;
import org.example.Models.RequestModels.SendEmailRequest;
import org.example.Models.ResponseModels.Response;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


public class EmailTemplates {
    private final EmailHelper emailHelper;
    public EmailTemplates(String senderName, String fromAddress, String sendgridApiKey) {
        this.emailHelper = new EmailHelper(fromAddress, senderName, sendgridApiKey);
    }

    public Response<Boolean> sendNewUserAccountConfirmation(
            Environment environment,
            Carrier carrier,
            GoogleCred googleCred,
            long userId,
            String userToken,
            String userEmail,
            String temporaryPassword
    ) throws IOException {
        String profile = environment.getActiveProfiles().length > 0 ? environment.getActiveProfiles()[0] : "default";
        String apiUrl = "";
        switch (profile) {
            case "development":
                apiUrl = "https://poetic-pheasant-legal.ngrok-free.app";
                break;
            case "localhost":
                apiUrl = "http://localhost:5567";
                break;
            case "staging":
                // Add staging URL here
                break;
            case "uat":
                // Add UAT URL here
                break;
            case "main":
                // Add main URL here
                break;
        }

        // Generate the confirmation account link
        String confirmAccountLink = String.format(
                "%s/confirmEmail?UserId=%s&Token=%s",
                apiUrl,
                userId,
                java.net.URLEncoder.encode(userToken, java.nio.charset.StandardCharsets.UTF_8)
        );

        // Fetch the logo from Firebase and encode it as Base64
        FirebaseHelper firebaseHelper = new FirebaseHelper(googleCred);
        String filePath = profile + "/" + carrier.getDatabaseName() + "/Logo.png";
        byte[] logoBytes = firebaseHelper.downloadFileAsBytesFromFirebase(filePath);
        String companyLogoBase64 = Base64.getEncoder().encodeToString(logoBytes);

        // Create the email template with inline image reference (cid)
        String emailTemplate = String.format(
                """
                <div style="font-family: Arial, sans-serif; color: #333;">
                    <header style="padding: 10px; text-align: center; background-color: #f3f4f6;">
                        <img src="cid:companyLogo" alt="%s Logo" style="width: 300px; height: 200px; margin-bottom: 20px;">
                        <h2>Welcome to %s</h2>
                    </header>
                    <main style="padding: 20px;">
                        <p>Dear User,</p>
                        <p>Please click on the link below to confirm your email account:</p>
                        <p>
                            <a href="%s" style="background-color: #4CAF50; color: white; padding: 10px 20px; text-decoration: none; border-radius: 5px;">
                                Confirm Account
                            </a>
                        </p>
                        <p>If you are unable to click the button, use the following link:</p>
                        <p><a href="%s">%s</a></p>
                        <p>Your temporary password is: <strong>%s</strong></p>
                    </main>
                    <footer style="padding: 10px; text-align: center; background-color: #f3f4f6; font-size: 12px; color: #666;">
                        <p>Thank you for choosing %s!</p>
                        <p>For support, contact us at <a href="mailto:%s">%s</a></p>
                    </footer>
                </div>
                """,
                carrier.getName(),
                carrier.getName(),
                confirmAccountLink,
                confirmAccountLink,
                confirmAccountLink,
                temporaryPassword,
                carrier.getName(),
                carrier.getSupportEmail(),
                carrier.getSupportEmail()
        );

        // Plain text fallback content
        String plainText = String.format(
                "Please click on the link below to confirm your email account:\n%s\n\n" +
                        "Your temporary password is: %s\n\n" +
                        "Thank you for choosing %s!",
                confirmAccountLink, temporaryPassword, carrier.getName()
        );

        // Create SendEmailRequest object with the details
        SendEmailRequest sendEmailRequest = new SendEmailRequest();
        sendEmailRequest.setToAddress(List.of(userEmail));
        sendEmailRequest.setSubject("Account Confirmation with temporary password");
        sendEmailRequest.setHtmlContent(emailTemplate);
        sendEmailRequest.setPlainTextContent(plainText);

        // Create an attachment for the company logo
        Attachments logoAttachment = new Attachments();
        logoAttachment.setFilename("logo.png");
        logoAttachment.setContent(companyLogoBase64);
        logoAttachment.setType("image/png");
        logoAttachment.setDisposition("inline");
        logoAttachment.setContentId("companyLogo"); // Reference in HTML

        // Add attachment to the request
        List<Attachments> attachments = new ArrayList<>();
        attachments.add(logoAttachment);
        sendEmailRequest.setAttachments(attachments);

        // Send the account confirmation email using email helper
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
