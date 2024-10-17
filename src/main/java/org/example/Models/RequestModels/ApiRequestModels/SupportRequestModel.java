package org.example.Models.RequestModels.ApiRequestModels;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.List;

@Getter
@Setter
public class SupportRequestModel {
    private String jsonContent;
    private Map<String, String> imagesBase64;
    private JSONDocNode jsonDocNode;

    @Getter
    @Setter
    public static class JSONDocNode {
        private int version;
        private String type = "doc";
        private List<JSONNode> content;
    }
    @Getter
    @Setter
    public static class JSONNode {
        private String type;
        private Map<String, Object> attrs;
        private List<JSONNode> content;
        private List<Object> marks;
        private String text;
    }
}