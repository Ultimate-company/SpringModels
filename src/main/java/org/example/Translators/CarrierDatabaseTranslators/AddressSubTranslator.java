package org.example.Translators.CarrierDatabaseTranslators;

import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import org.example.ApiRoutes;
import org.example.Models.CommunicationModels.CarrierModels.Address;
import org.example.Models.ResponseModels.Response;
import org.example.Translator;
import org.example.Translators.CarrierDatabaseTranslators.Interfaces.IAddressSubTranslator;

import java.util.Collections;

public class AddressSubTranslator extends Translator implements IAddressSubTranslator {
    public AddressSubTranslator(String token, Long auditUserId, Long carrierId, String apiUrl) {
        super(token, auditUserId, carrierId, apiUrl);
    }

    @Override
    public Response<Boolean> toggleAddress(long id) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.ADDRESS + "/" + ApiRoutes.AddressSubRoute.TOGGLE_ADDRESS,
                        Collections.singletonMap("id", id)),
                "DELETE",
                new TypeToken<Response<Boolean>>(){}.getType(),
                null);
    }

    @Override
    public Response<Address> getAddressById(long id) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.ADDRESS + "/" + ApiRoutes.AddressSubRoute.GET_ADDRESS_BY_ID,
                        Collections.singletonMap("id", id)),
                "GET",
                new TypeToken<Response<Address>>(){}.getType(),
                null);
    }

    @Override
    public Response<Long> insertAddress(Address address) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.ADDRESS + "/" + ApiRoutes.AddressSubRoute.INSERT_ADDRESS),
                "PUT",
                new TypeToken<Response<Long>>(){}.getType(),
                address);
    }

    @Override
    public Response<Long> updateAddress(Address address) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.ADDRESS + "/" + ApiRoutes.AddressSubRoute.UPDATE_ADDRESS),
                "POST",
                new TypeToken<Response<Long>>(){}.getType(),
                address);
    }

    @Override
    public Response<Address> getAddressByUserId(long id) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.ADDRESS + "/" + ApiRoutes.AddressSubRoute.GET_ADDRESS_BY_USER_ID,
                        Collections.singletonMap("id", id)),
                "GET",
                new TypeToken<Response<Address>>(){}.getType(),
                null);
    }
}