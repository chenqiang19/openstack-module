package com.ict.cloud.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
    public static final String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS";
    public static final SimpleDateFormat format = new SimpleDateFormat(
            "yyyy-MM-dd'T'HH:mm:ss.SSSSSS");

    public static String format(Date date) {
        return format.format(date);
    }
    public static Date parse(String source) {
        Date date = null;
        try {
            if(!source.equals("")){
                date = format.parse(source);
            }
        } catch (ParseException localParseException) {
        }
        return date;
    }
}
