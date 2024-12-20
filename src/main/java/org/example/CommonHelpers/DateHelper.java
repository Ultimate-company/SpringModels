package org.example.CommonHelpers;

import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.time.LocalDateTime;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateHelper {
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    private static void resetTime(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    public static boolean isDateLessThanCurrentUTC(Date dateToCheck) {
        // Get the current UTC date and time
        Calendar currentCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        currentCalendar.setTime(new Date());  // Get current time in UTC
        resetTime(currentCalendar);  // Reset the time to 00:00:00 UTC
        Date currentUTCDate = currentCalendar.getTime();

        // Reset time part for the input date
        Calendar dateCalendar = Calendar.getInstance();
        dateCalendar.setTime(dateToCheck);
        resetTime(dateCalendar);  // Reset the time of the input date
        Date inputDate = dateCalendar.getTime();

        // Compare the dates
        return inputDate.before(currentUTCDate);
    }

    public static String getCurrentUTCDateTime() {
        // Get the current date and time in UTC
        LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);

        // Format the current date-time in the specified format
        return now.format(formatter);
    }

    public static Date getCurrentUTCDate() {
        return Date.from(LocalDateTime.now(ZoneOffset.UTC).atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date convertLocalDateTimeToDate(LocalDateTime localDateTime) {
        // Convert LocalDateTime to Instant using system default zone
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();

        // Convert Instant to Date
        return Date.from(instant);
    }

    public static String formatDateString(String dateString) {
        // Remove ordinal suffix from the day part using regex
        dateString = dateString.replaceAll("(\\d+)(st|nd|rd|th)", "$1");

        // List of possible date formats to handle various input cases
        String[] dateFormats = {
                "MMMM dd, yyyy, h:mm a",  // Example: December 19, 2024, 09:34 PM
                "yyyy-MM-dd'T'HH:mm:ss",          // Example: 2024-12-19T07:32:12
                "MM/dd/yyyy, h:mm:ss a",         // Example: 12/19/2024, 7:32:12 AM
                "yyyy-MM-dd HH:mm:ss",           // Example: 2024-12-19 07:32:12
                "dd/MM/yyyy HH:mm:ss",           // Example: 19/12/2024 07:32:12
                "yyyy/MM/dd HH:mm:ss",           // Example: 2024/12/19 07:32:12
                "yyyy-MM-dd HH:mm:ss.SSS",       // Example: 2024-12-19 07:32:12.123
                "MM/dd/yyyy HH:mm:ss",           // Example: 12/19/2024 07:32:12
                "yyyy-MM-dd",                    // Example: 2024-12-19
                "MM/dd/yyyy",                    // Example: 12/19/2024
                "yyyyMMdd",                      // Example: 20241219
                "yyyy/MM/dd"                     // Example: 2024/12/19
        };

        for (String format : dateFormats) {
            try {
                // Try parsing the input string with each format
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(format);
                LocalDateTime localDateTime = LocalDateTime.parse(dateString, inputFormatter);

                // Return the formatted output
                return localDateTime.format(formatter);
            } catch (DateTimeParseException e) {
                // Ignore parsing errors and try the next format
            }
        }

        // If no format matched, return an error message
        return "Invalid Date Format";
    }

    public static LocalDateTime stringToLocalDateTime(String dateString) {
        dateString = formatDateString(dateString);

        // Parse the string to LocalDateTime
        return LocalDateTime.parse(dateString, formatter);
    }

    public static boolean isStartDateTimeAfterEndDateTime(String startDateTimeString, String endDateTimeString) {
        // Format the input date strings to LocalDateTime format
        startDateTimeString = formatDateString(startDateTimeString);
        endDateTimeString = formatDateString(endDateTimeString);

        // Parse LocalDateTime from the formatted strings
        LocalDateTime startDateTime = LocalDateTime.parse(startDateTimeString, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endDateTimeString, formatter);

        // Compare the LocalDateTime objects
        return startDateTime.isAfter(endDateTime);
    }

    public static String convertLocalDateTimeToString(LocalDateTime localDateTime) {
        return localDateTime.format(formatter);
    }
}
