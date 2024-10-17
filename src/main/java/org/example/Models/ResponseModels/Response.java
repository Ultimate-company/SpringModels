package org.example.Models.ResponseModels;

import com.nimbusds.jose.shaded.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T> {
    @SerializedName("success")
    private boolean isSuccess;
    private String message;
    private T item;

    public Response(boolean isSuccess, String message, T item) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.item = item;
    }
    public Response(boolean isSuccess){
        this.isSuccess = isSuccess;
    }
    public Response() {
    }
}

