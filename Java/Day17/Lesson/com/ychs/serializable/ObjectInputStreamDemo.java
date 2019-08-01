/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.serializable;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/01 20:59
 */
public class ObjectInputStreamDemo {
    private static Logger logger = Logger.getLogger(ObjectInputStreamDemo.class);
    public static void main(String[] args) {
        try {
            readObj();//对象的反序列化。
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void readObj() throws FileNotFoundException, IOException, ClassNotFoundException {
	    /*//1,定义流对象关联存储了对象文件。
        FileInputStream fis = new FileInputStream("e:\\file\\obj.object");
        //2,建立用于读取对象的功能对象。
        ObjectInputStream ois = new ObjectInputStream(fis);*/
        //1、创建反序列化流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.txt"));
        //2、读取对象信息
        Person p1 = (Person)ois.readObject();
        Person p2 = (Person)ois.readObject();
        logger.info(p1);
        logger.info(p2);
        //3、关闭流
        ois.close();

    }
}
