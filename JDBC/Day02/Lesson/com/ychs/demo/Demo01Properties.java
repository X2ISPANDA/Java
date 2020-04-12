/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/20 11:20
 */
public class Demo01Properties {
    private static Logger logger = LogManager.getLogger(Demo01Properties.class);
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        prop.load(Demo01Properties.class.getResourceAsStream("/db.properties"));
        logger.debug(prop.getProperty("driver"));
        logger.debug(prop.getProperty("url"));
        logger.debug(prop.getProperty("username"));
        logger.debug(prop.getProperty("password"));

    }
}
