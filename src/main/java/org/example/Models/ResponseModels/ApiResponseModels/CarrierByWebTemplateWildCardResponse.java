package org.example.Models.ResponseModels.ApiResponseModels;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.Models.CommunicationModels.CentralModels.Carrier;

@Getter
@Setter
@Accessors(chain = true)
public class CarrierByWebTemplateWildCardResponse {
    private Carrier carrier;
    private long webTemplateId;
    private String apiAccessKey;
    private String wildCard;
}
