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
        String htmlContent = """
        <html>
          <body style='font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;'>
            <div style='max-width: 600px; margin: 0 auto; background-color: #ffffff; border-radius: 8px; box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);'>
              <header style='text-align: center; padding: 20px 0;'>
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 87.98 92.12" style='width: 150px; margin-bottom: 10px;'>
                  <path d="M6.46 69.53c3.17 2.5 6.37 4.94 10.19 6.36 13.43 5 26 3.14 37.2-5.58A22.62 22.62 0 0 0 62.52 52c.09-15.33 0-30.65 0-46 0-3.81.25-4.16 4-3.33C79 5.47 87.64 14.76 87.88 27.38c.17 8.26.08 16.53 0 24.79a39.38 39.38 0 0 1-31.35 38.47c-10.38 2.29-20.47 2.18-30.31-2.12a44.12 44.12 0 0 1-20-17.6A3.08 3.08 0 0 1 6 70z" fill="#0bf"/>
                  <path d="M0 23.1V3.46C0 .3.65-.42 3.62.2c12.16 2.55 21.27 11 21.7 24.33.25 7.74.11 15.5 0 23.26-.08 6.65 2.25 12 7.7 16 2 1.44 1.88 2.15-.37 3.16-7.94 3.54-20.48.89-26.83-7.16C1.79 54.67.3 48.77.1 42.48-.1 36 .06 29.56.06 23.1z" fill="#5592ff"/>
                </svg>
                <h1 style='color: #333;'>Ultimate Company</h1>
              </header>
              <div style='padding: 20px;'>
                <h3 style='color: #333;'>Your new password is:</h3>
                <p style='font-size: 18px; font-weight: bold; color: #555;'>""" + password + """
                </p>
                <p style='color: #777; margin-top: 20px;'>For your security, please change this password after logging in.</p>
                <p style='color: #777;'>If you did not request a new password, please contact our support team immediately.</p>
              </div>
              <footer style='text-align: center; padding: 10px 0; background-color: #333; color: white; border-top: 1px solid #ddd;'>
                <p>&copy; """ + java.time.Year.now() + """ 
                Ultimate Company. All rights reserved.</p>
                <p>Mumbai Maharashtra</p>
              </footer>
            </div>
          </body>
        </html>""";

        sendEmailRequest.setHtmlContent(htmlContent);

        // Send the reset password email using the email helper
        return emailHelper.sendEmail(sendEmailRequest);
    }
}