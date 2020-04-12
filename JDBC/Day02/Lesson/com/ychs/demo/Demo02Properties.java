/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ResourceBundle;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/20 11:27
 */
public class Demo02Properties {
    private static Logger logger = LogManager.getLogger(Demo02Properties.class);

    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        logger.debug(bundle.getString("driver"));
        logger.debug(bundle.getString("url"));
        logger.debug(bundle.getString("username"));
        logger.debug(bundle.getString("password"));

    }
}
