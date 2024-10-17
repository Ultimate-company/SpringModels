package org.example.Models.ResponseModels.ApiResponseModels;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.Models.CommunicationModels.CarrierModels.WebTemplate;
import org.example.Models.CommunicationModels.CarrierModels.WebTemplatesFontStyle;

@Getter
@Setter
@Accessors(chain = true)
public class WebTemplateResponseModel {
    private WebTemplate webTemplate;
    private String wildCard;
    private WebTemplatesFontStyle cardHeaderFontStyle;
    private WebTemplatesFontStyle cardSubTextFontStyle;
    private WebTemplatesFontStyle headerFontStyle;
}
