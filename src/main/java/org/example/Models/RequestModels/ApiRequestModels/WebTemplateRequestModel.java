package org.example.Models.RequestModels.ApiRequestModels;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.Annotations.FrontEndVariable;
import org.example.Annotations.IsRequired;
import org.example.Models.CommunicationModels.CarrierModels.WebTemplate;
import org.example.Models.CommunicationModels.CarrierModels.WebTemplatesFontStyle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Accessors(chain = true)
public class WebTemplateRequestModel extends BaseRequest {
    @FrontEndVariable
    @IsRequired
    private WebTemplate webTemplate;

    @FrontEndVariable
    @IsRequired
    private WebTemplatesFontStyle cardHeaderFontStyle;

    @FrontEndVariable
    @IsRequired
    private WebTemplatesFontStyle cardSubTextFontStyle;

    @FrontEndVariable
    @IsRequired
    private WebTemplatesFontStyle headerFontStyle;

    @FrontEndVariable
    @IsRequired
    private List<String> sortOptions;

    @FrontEndVariable
    @IsRequired
    private List<String> filterOptions;

    @FrontEndVariable
    @IsRequired
    private List<Long> selectedProductIds;

    @FrontEndVariable
    @IsRequired
    private List<String> acceptedPaymentOptions;

    @FrontEndVariable
    @IsRequired
    private Map<String, List<String>> stateCityMapping;

    // fields used by Webtemplates
    private long productId;
    private long quantity;
    private long webTemplateId;
}