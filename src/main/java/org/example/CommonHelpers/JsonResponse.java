package org.example.CommonHelpers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonResponse<T> {
    public enum JsonType{
        Success,
        Error,
        Warning,
        Redirect
    }

    private JsonType responseType;
    private String message;
    private T item;
    private String redirectLink;

    // constructor for success and error
    public JsonResponse(JsonType responseType, String message, T item) {
        this.responseType = responseType;
        this.message = message;
        this.item = item;
    }

    // constructor for redirecting pages.
    public JsonResponse(String redirectLink, String message){
        this.responseType = JsonType.Redirect;
        this.message = message;
        this.redirectLink = redirectLink;
    }
}
