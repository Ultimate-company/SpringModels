package org.example.Translators.CentralDatabaseTranslators.Interfaces;

import org.example.Models.CommunicationModels.CentralModels.GoogleUser;
import org.example.Models.RequestModels.ApiRequestModels.LoginRequestModel;
import org.example.Models.ResponseModels.Response;
import org.example.Models.CommunicationModels.CentralModels.User;


public interface ILoginSubTranslator {
    /**
     * @summary Confirms the email address associated with the provided user credentials.
     * @param loginRequestModel Login request model containing user credentials (likely userId and apiKey).
     * @return Response containing success or failure of the confirmation process.
     */
    Response<Boolean> confirmEmail(LoginRequestModel loginRequestModel);

    /**
     * @summary Signs in a user using the provided email and password.
     * @param loginRequestModel Login request model containing email and password.
     * @return Response containing user data if sign-in is successful, otherwise error details.
     */
    Response<User> signIn(LoginRequestModel loginRequestModel);

    /**
     * @summary Creates a new user account.
     * @param user User object representing the new user to be signed up.
     * @return Response containing message or confirmation details about the signup process.
     */
    Response<String> signUp(User user) throws Exception;

    /**
     * @summary Signs in a user using their Google account information.
     * @param googleUser GoogleUser object containing Google account details.
     * @return Response containing user data if Google sign-in is successful, otherwise error details.
     */
    Response<User> googleSignIn(GoogleUser googleUser);

    /**
     * @summary Initiates a password reset process for the associated email address.
     * @param loginRequestModel Login request model likely containing the user's email address.
     * @return Response indicating success or failure of the password reset initiation.
     */
    Response<Boolean> resetPassword(LoginRequestModel loginRequestModel) throws Exception;

    /**
     * @summary Obtains an authentication token for the user based on the provided credentials.
     * @param loginRequestModel Login request model possibly containing userId and apiKey.
     * @return Response containing the authentication token if successful, otherwise error details.
     */
    Response<String> getToken(LoginRequestModel loginRequestModel);
}
