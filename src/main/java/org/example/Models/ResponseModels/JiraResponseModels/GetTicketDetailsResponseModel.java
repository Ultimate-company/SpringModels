package org.example.Models.ResponseModels.JiraResponseModels;

import lombok.Getter;
import lombok.Setter;
import org.example.Models.CommunicationModels.CarrierModels.SupportComments;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class GetTicketDetailsResponseModel {
    public String expand;
    public String id;
    public String self;
    public String key;
    private ResponseModelObjects.Fields fields;
    private ResponseModelObjects.RenderedFields renderedFields;
    private List<SupportComments> supportComments;
    private Map<Long, String> userIdFullNameMapping;
}
