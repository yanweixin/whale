package me.whale.utils.lang;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class DateUtil {
    private final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final static DateTimeFormatter ISO_DATE_TIME_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;
    private final static DateTimeFormatter DATE_TIME_FORMATTER_SAFE_STRING = DateTimeFormatter.ofPattern("yyyy-MM-dd HH_mm_ss_SSS");
    private final static DateTimeFormatter DATE_FORMATTER_SAFE_STRING = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static LocalDateTime toLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static Date stringToDate(String source) {
        return Date.from(LocalDate.parse(source, DATE_FORMATTER).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date[] stringToDate(String[] sources) {
        if (sources.length == 0) {
            throw new IndexOutOfBoundsException("Array length must be greater than zero");
        }
        Date[] dates = new Date[sources.length];
        for (int i = 0; i < sources.length; i++) {
            dates[i] = stringToDate(sources[i]);
        }
        return dates;
    }

    public static LocalDateTime stringToLocalDate(String source) {
        return LocalDateTime.parse(source, DATE_TIME_FORMATTER);
    }

    public static String safeDateTimeString() {
        LocalDateTime now = LocalDateTime.now();
        return DATE_TIME_FORMATTER_SAFE_STRING.format(now);
    }

    public static String safeDateString() {
        LocalDateTime now = LocalDateTime.now();
        return DATE_FORMATTER_SAFE_STRING.format(now);
    }

    public static String duration(long startTime, long endTime) {
        return duration(endTime - startTime);
    }

    public static String duration(long duration) {
        long hours = TimeUnit.MILLISECONDS.toHours(duration);
        long minute = TimeUnit.MILLISECONDS.toMinutes(duration) - (TimeUnit.MILLISECONDS.toHours(duration) * 60);
        long second = TimeUnit.MILLISECONDS.toSeconds(duration) - (TimeUnit.MILLISECONDS.toMinutes(duration) * 60);
        return String.format("%d hours, %d minutes , %d seconds", hours, minute, second);
    }
}

