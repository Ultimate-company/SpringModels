package org.example.Translators.CentralDatabaseTranslators;

import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import org.example.ApiRoutes;
import org.example.Models.CommunicationModels.CentralModels.GoogleUser;
import org.example.Models.RequestModels.ApiRequestModels.LoginRequestModel;
import org.example.Models.ResponseModels.Response;
import org.example.Translator;
import org.example.Models.CommunicationModels.CentralModels.User;
import org.example.Translators.CentralDatabaseTranslators.Interfaces.ILoginSubTranslator;

public class LoginSubTranslator extends Translator implements ILoginSubTranslator {

    public LoginSubTranslator(String apiUrl) {
        super(null, null, null, apiUrl);
    }

    @Override
    public Response<Boolean> confirmEmail(LoginRequestModel loginRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.LOGIN + "/" + ApiRoutes.LoginSubRoute.CONFIRM_EMAIL),
                "POST",
                new TypeToken<Response<Boolean>>(){}.getType(),
                loginRequestModel);
    }

    @Override
    public Response<User> signIn(LoginRequestModel loginRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.LOGIN + "/" + ApiRoutes.LoginSubRoute.SIGN_IN),
                "POST",
                new TypeToken<Response<User>>(){}.getType(),
                loginRequestModel);
    }

    @Override
    public Response<String> signUp(User user) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.LOGIN + "/" + ApiRoutes.LoginSubRoute.SIGN_UP),
                "PUT",
                new TypeToken<Response<String>>(){}.getType(),
                user);
    }

    @Override
    public Response<User> googleSignIn(GoogleUser googleUser) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.LOGIN + "/" + ApiRoutes.LoginSubRoute.GOOGLE_SIGN_IN),
                "POST",
                new TypeToken<Response<User>>(){}.getType(),
                googleUser);
    }

    @Override
    public Response<Boolean> resetPassword(LoginRequestModel loginRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.LOGIN + "/" + ApiRoutes.LoginSubRoute.RESET_PASSWORD),
                "POST",
                new TypeToken<Response<Boolean>>(){}.getType(),
                loginRequestModel);
    }

    @Override
    public Response<String> getToken(LoginRequestModel loginRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.LOGIN + "/" + ApiRoutes.LoginSubRoute.GET_TOKEN),
                "GET",
                new TypeToken<Response<String>>(){}.getType(),
                loginRequestModel);
    }
}
