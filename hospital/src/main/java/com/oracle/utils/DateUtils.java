package com.oracle.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * @author zhaoran
 * @title: DateUtils
 * @projectName aaa
 * @description: TODO
 * @date 2024/6/27/15:56
 * @sign:
 */
public class DateUtils {
    public static Date convertToDateLocal(String datetimeLocal) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(datetimeLocal, formatter);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date convertToDate(String datetimeLocal) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return formatter.parse(datetimeLocal);
    }

    public static String converToStringLocal(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String dateTimeString = dateFormat.format(date);
        return dateTimeString;
    }

    public static String converToString(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateTimeString = dateFormat.format(date);
        return dateTimeString;
    }
}
