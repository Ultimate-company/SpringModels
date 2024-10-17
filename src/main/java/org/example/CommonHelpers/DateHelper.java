package org.example.CommonHelpers;

import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.time.LocalDateTime;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateHelper {
    private static void resetTime(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    public static boolean isDateLessThanCurrentUTC(Date dateToCheck) {
        // Get the current UTC date
        Calendar currentCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        currentCalendar.setTime(dateToCheck);
        resetTime(currentCalendar);
        Date currentUTCDate = currentCalendar.getTime();

        // Reset time part for the input date
        Calendar dateCalendar = Calendar.getInstance();
        dateCalendar.setTime(dateToCheck);
        resetTime(dateCalendar);
        Date inputDate = dateCalendar.getTime();

        // Compare the dates
        return inputDate.before(currentUTCDate);
    }

    public static String getCurrentUTCDateTime() {
        // Get the current date and time in UTC
        LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);

        // Define the desired date-time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy_HHmmss");

        // Format the current date-time in the specified format
        return now.format(formatter);
    }

    public static Date getCurrentUTCDate()
    {
        return Date.from(LocalDateTime.now(ZoneOffset.UTC).atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date convertLocalDateTimeToDate(LocalDateTime localDateTime) {
        // Convert LocalDateTime to ZonedDateTime at the system default time zone
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());

        // Convert ZonedDateTime to Instant
        Instant instant = zonedDateTime.toInstant();

        // Convert Instant to Date
        return Date.from(instant);
    }
}
