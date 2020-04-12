package com.ychs.ssm.day04.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Mingyu Xiong
 * @description:字符串时间转换成Java时间的参数绑定转换器
 * @date 2020/3/10 20:09
 */
@Component
public class StringToDateConverter implements Converter<String, Date> {

    /**
     * 入参String类型的时间由SpringMVC容器负责传入
     * String数据来源于请求报文
     * convert方法负责将String时间转换成Date类型，之后进行返回
     * 返回后的Date同样由SpringMVC容器负责将其绑定到Controller方法的入参当中去。
     * @param dateString
     * @return
     */
    @Override
    public Date convert(String dateString) {
        Date date = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
