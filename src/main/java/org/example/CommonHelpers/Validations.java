package org.example.CommonHelpers;

import org.example.Models.ResponseModels.Response;
import org.springframework.util.StringUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {

    public static Response<Boolean> isValidAddress(String line1, String state, String city, String zipCode, String phoneOnAddress, String nameOnAddress) {
        if (!StringUtils.hasText(line1)) {
            return new Response<>(false, "Address Line 1 is Required.", false);
        }

        if (!StringUtils.hasText(state)) {
            return new Response<>(false, "Address State is Required.", false);
        }

        if (!StringUtils.hasText(city)) {
            return new Response<>(false, "Address City is Required.", false);
        }

        if (!Validations.isValidZip(zipCode)) {
            return new Response<>(false, "Address zipCode is Required.", false);
        }

        if(!Validations.isValidPhone(phoneOnAddress)){
            return new Response<>(false, "Phone on address is Required.", false);
        }

        if(!Validations.isValidName(nameOnAddress)){
            return new Response<>(false, "Name on address is Required.", false);
        }

        return new Response<>(true, "success", true);
    }

    public static boolean isValidEmail(String value) {
        return value != null &&
                !value.trim().isEmpty() &&
                value.length() < 100 &&
                value.matches("^\\w\\S+?@\\S+?\\.\\w+?$");
    }

    public static boolean isValidPhone(String phone) {
        String value = phone.replaceAll("[-\\s()]", "");
        final int numberSize = 10;

        String loop = value.replaceAll("[^0-9]", "");
        int count = loop.length();
        return count == numberSize || (count == numberSize + 1 && loop.charAt(0) == '1');
    }

    public static boolean isValidName(String value) {
        return value != null &&
                !value.trim().isEmpty() &&
                value.length() < 50;
    }

    public static boolean isValidZip(String value) {
        return value != null &&
                !value.trim().isEmpty() &&
                value.length() == 6 &&
                value.matches("\\d{6}");
    }

    public static boolean isValidUrl(String url) {
        if (url == null || url.trim().isEmpty()) {
            return false;
        }

        try {
            URI myUri = new URI(url);
            return myUri.getScheme() != null && ("http".equals(myUri.getScheme()) || "https".equals(myUri.getScheme()));
        } catch (URISyntaxException e) {
            return false;
        }
    }

    public static boolean isCreditCardInfoValid(String cardNo, String expiryDate, String cvv) {
        Pattern cardCheck = Pattern.compile("^(1298|1267|4512|4567|8901|8933)([-\\s]?[0-9]{4}){3}$");
        Pattern monthCheck = Pattern.compile("^(0[1-9]|1[0-2])$");
        Pattern yearCheck = Pattern.compile("^20[0-9]{2}$");
        Pattern cvvCheck = Pattern.compile("^\\d{3}$");

        Matcher cardMatcher = cardCheck.matcher(cardNo);
        if (!cardMatcher.matches()) {
            return false;
        }

        Matcher cvvMatcher = cvvCheck.matcher(cvv);
        if (!cvvMatcher.matches()) {
            return false;
        }

        String[] dateParts = expiryDate.split("/");
        if (dateParts.length != 2 || !monthCheck.matcher(dateParts[0]).matches() || !yearCheck.matcher(dateParts[1]).matches()) {
            return false;
        }

        int year = Integer.parseInt(dateParts[1]);
        int month = Integer.parseInt(dateParts[0]);
        int lastDateOfExpiryMonth = YearMonth.of(year, month).lengthOfMonth();
        LocalDateTime cardExpiry = LocalDateTime.of(year, month, lastDateOfExpiryMonth, 23, 59, 59);

        return cardExpiry.isAfter(LocalDateTime.now()) && cardExpiry.isBefore(LocalDateTime.now().plusYears(6));
    }
}
