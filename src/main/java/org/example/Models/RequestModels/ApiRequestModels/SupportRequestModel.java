package org.example.Models.RequestModels.ApiRequestModels;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.Annotations.FrontEndVariable;
import org.example.Annotations.IsRequired;

import java.util.Map;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class SupportRequestModel {
    @FrontEndVariable
    @IsRequired
    private String jsonContent;

    @FrontEndVariable
    @IsRequired
    private Map<String, String> imagesBase64;
    private JSONDocNode jsonDocNode;

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class JSONDocNode {
        private int version;
        private String type = "doc";
        private List<JSONNode> content;
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class JSONNode {
        private String type;
        private Map<String, Object> attrs;
        private List<JSONNode> content;
        private List<Object> marks;
        private String text;
    }
}