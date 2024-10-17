package org.example.CommonHelpers;

import org.springframework.util.StringUtils;

public class DataCleaner {
    public static String cleanPhone(String phone){
        if(!StringUtils.hasText(phone)) return "";
        return phone
                .replace("-", "")
                .replace("(", "")
                .replace(")","")
                .replace(" ", "")
                .replace("+", "");
    }
}