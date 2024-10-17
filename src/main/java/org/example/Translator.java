package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nimbusds.jose.shaded.gson.Gson;
import com.nimbusds.jose.shaded.gson.GsonBuilder;
import lombok.Getter;

import org.example.Adapters.DateAdapter;
import org.example.Adapters.LocalDateTimeAdapter;
import org.example.Models.ResponseModels.Response;
import org.springframework.util.StringUtils;

import javax.sql.rowset.serial.SerialBlob;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

public class Translator
{
    private static final String API_URL = "http://localhost:8080/api";
    private static final String JSON_CONTENT_TYPE = "application/json";
    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Getter
    private static Long auditUserId, carrierId, webTemplateId;

    @Getter
    private static String token, wildCard;
    protected Translator(String token, Long auditUserId, Long carrierId){
        Translator.token = token;
        Translator.auditUserId = auditUserId;
        Translator.carrierId = carrierId;
    }
    protected Translator(String token, String wildCard, Long webTemplateId, Long carrierId, Long userId) {
        Translator.token = token;
        Translator.wildCard = wildCard;
        Translator.webTemplateId = webTemplateId;
        Translator.carrierId = carrierId;
        Translator.auditUserId = userId;
    }

    public String getApiUrl(String endpoint) {
        StringBuilder urlBuilder = new StringBuilder(API_URL).append("/").append(endpoint);

        boolean isFirstQueryParam = true;

        if (auditUserId != null) {
            urlBuilder.append("?AuditUserId=").append(auditUserId);
            isFirstQueryParam = false;
        }

        if (carrierId != null) {
            urlBuilder.append(isFirstQueryParam ? "?" : "&").append("CarrierId=").append(carrierId);
            isFirstQueryParam = false;
        }

        if (webTemplateId != null) {
            urlBuilder.append(isFirstQueryParam ? "?" : "&").append("WebTemplateId=").append(webTemplateId);
            isFirstQueryParam = false;
        }

        if (wildCard != null) {
            urlBuilder.append(isFirstQueryParam ? "?" : "&").append("WildCard=").append(wildCard);
            isFirstQueryParam = false;
        }

        return urlBuilder.toString();
    }

    public String getApiUrl(String endpoint, Map<String, Object> queryParams) {
        StringBuilder urlBuilder = new StringBuilder(API_URL).append("/").append(endpoint);

        boolean isFirstQueryParam = true;

        if (auditUserId != null) {
            urlBuilder.append("?AuditUserId=").append(auditUserId);
            isFirstQueryParam = false;
        }

        if (carrierId != null) {
            urlBuilder.append(isFirstQueryParam ? "?" : "&").append("CarrierId=").append(carrierId);
            isFirstQueryParam = false;
        }

        if (webTemplateId != null) {
            urlBuilder.append(isFirstQueryParam ? "?" : "&").append("WebTemplateId=").append(webTemplateId);
            isFirstQueryParam = false;
        }

        if (wildCard != null) {
            urlBuilder.append(isFirstQueryParam ? "?" : "&").append("WildCard=").append(wildCard);
            isFirstQueryParam = false;
        }

        if (queryParams != null && !queryParams.isEmpty()) {
            for (Map.Entry<String, Object> entry : queryParams.entrySet()) {
                urlBuilder.append(isFirstQueryParam ? "?" : "&").append(entry.getKey()).append("=").append(entry.getValue());
                isFirstQueryParam = false;
            }
        }

        return urlBuilder.toString();
    }

    public <T> Response<T> httpResponse(String url, String methodType, Type type, Object content) {
        try{
            HttpClient client = HttpClient.newHttpClient();
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                    .registerTypeAdapter(Date.class, new DateAdapter())
                    .create();

            String requestBody = content != null ? gson.toJson(content) : "";

            var request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .header("Content-Type", "application/json")
                    .method(methodType, HttpRequest.BodyPublishers.ofString(requestBody));

            if(StringUtils.hasText(getToken())){
                request.header("Authorization", "Bearer " + getToken());
            }

            HttpResponse<String> response = client.send(request.build(), HttpResponse.BodyHandlers.ofString());

            return gson.fromJson(response.body(), type);
        }
        catch (Exception e){
            return new Response<>(false, "Exception occurred: " + e, null);
        }
    }
}