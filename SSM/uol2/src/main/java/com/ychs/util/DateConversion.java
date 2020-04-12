package com.ychs.util;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConversion implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date d = null;
        try {
            d = sf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }
}
