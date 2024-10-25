package org.example.Models.ResponseModels.ApiResponseModels;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.Models.CommunicationModels.CentralModels.Carrier;
import org.example.Models.CommunicationModels.CentralModels.GoogleCred;

@Getter
@Setter
@Accessors(chain = true)
public class GetCarrierResponseModel {
    private Carrier carrier;
    private GoogleCred googleCred;
}
