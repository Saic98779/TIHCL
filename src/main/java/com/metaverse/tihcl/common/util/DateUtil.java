package com.metaverse.tihcl.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String dateToString(Date date) {
        if (date == null) return null;
        DateFormat dateFormat = new SimpleDateFormat( "dd-MM-yyyy");
        return dateFormat.format(date);
    }

    public static Date stringToDate(String input) {
        if (input == null || input.trim().isEmpty()) {
            return null;
        }

        String[] dateFormats = {"yyyy-MM-dd", "dd-MM-yyyy", "dd-MMM-yyyy", "d-MMM-yyyy", "d-MM-yyyy"};

        for (String format : dateFormats) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                sdf.setLenient(false);
                Date parsedDate = sdf.parse(input);
                return java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(parsedDate));
            } catch (ParseException e) {
                // Try next format
            }
        }

        return null;
    }

}
