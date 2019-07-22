package com.ychs.demo;

import java.util.Enumeration;
import java.util.Properties;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/22 14:19
 */
public class SystemDemo {
    public static void main(String[] args) {
        System.out.println("aaaaaa");
        System.out.println("bbbbbb");
        System.err.println("error1");
        long l = System.currentTimeMillis();
        //System.exit(0);
        System.out.println("ccccc");
        System.out.println("ddddd");
        System.err.println("error2");
        System.out.println("eeeee");
        System.out.println("ffff");
        long l1 = System.currentTimeMillis();
        System.out.println(l);
        System.out.println(l1);
        System.out.println("运行时间是:"+(l1-l));

        Properties properties = System.getProperties();
        // 获得所有系统属性的key，返回Enumeration对象
        Enumeration propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            // 获取系统属性的键key
            String key = (String) propertyNames.nextElement();
            // 获得当前键key对应的值value
            String value = System.getProperty(key);
            System.out.println(key + "--->" + value);
        }
    }
}
