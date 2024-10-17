package org.example.Models.ResponseModels.ShippingResponseModels;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenerateInvoiceResponseModel {
    private boolean is_invoice_created;
    private String invoice_url;
    private String message;
}
