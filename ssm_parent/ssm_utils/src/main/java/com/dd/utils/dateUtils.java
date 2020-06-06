package com.dd.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dateUtils {


    //日期装换成String
    public static String dateToString(Date date, String pattern) throws Exception{

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String format = simpleDateFormat.format(date);

        return format;

    }


    //String转换成日期
    public static Date StringToDate(String date, String pattern) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Date parse = simpleDateFormat.parse(date);

        return parse;

    }

}
