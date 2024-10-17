package org.example.Models.RequestModels.ApiRequestModels;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.Models.CommunicationModels.CarrierModels.WebTemplate;
import org.example.Models.CommunicationModels.CarrierModels.WebTemplatesFontStyle;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class WebTemplateRequestModel extends BaseRequest {
    private WebTemplate webTemplate;
    private WebTemplatesFontStyle cardHeaderFontStyle;
    private WebTemplatesFontStyle cardSubTextFontStyle;
    private WebTemplatesFontStyle headerFontStyle;
    private List<String> sortOptions;
    private List<String> filterOptions;
    private List<Long> selectedProductIds;
    private List<String> acceptedPaymentOptions;
    private HashMap<String, List<String>> stateCityMapping;

    // fields used by Webtemplates
    private long productId;
    private long quantity;
    private long webTemplateId;
}