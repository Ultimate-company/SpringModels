package org.example.CommonHelpers;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class HTMLHelper {
    /**
     * Strips HTML tags from the given HTML string.
     *
     * @param html The HTML string to strip.
     * @return The resulting string with HTML tags removed, or null if the input is null or empty.
     */
    public static String stripHtml(String html) {
        // Check if the input is null or empty
        if (html == null || html.isEmpty()) {
            return null;
        }

        // Use regex to replace HTML tags with an empty string
        Pattern pattern = Pattern.compile("<.*?>");
        Matcher matcher = pattern.matcher(html);
        String strippedHtml = matcher.replaceAll("");

        return strippedHtml;
    }

    public static String replaceBrTags(String htmlContent) {
        if (htmlContent == null) {
            return null;
        }
        return htmlContent.replaceAll("(?i)<br(?!/)>", "<br/>");
    }
}
