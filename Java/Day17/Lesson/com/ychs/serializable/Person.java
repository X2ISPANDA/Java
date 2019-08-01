/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.serializable;

import java.io.*;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/01 20:49
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;//显示提供序列化版本号，如果反序列化时版本号与序列化版本号不一致会报异常
    private String name;
    private transient int age;
    static String sex = "男";
    public Person() {
        super();
    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Person other = (Person) obj;
        if (age != other.age) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

}

class ObjectOutputStreamDemo {
    public static void main(String[] args) {
        try {
            /*
             * 将一个对象存储到持久化(硬盘)的设备上。
             */
            writeObj();//对象的序列化。
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 完成对象序列化功能
     *
     * @return void 无返回值
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void writeObj() throws FileNotFoundException, IOException {
	   /* //1,明确存储对象的文件。
        FileOutputStream fos = new FileOutputStream("e:\\file\\obj.object");
        //2，给操作文件对象加入写入对象功能。
        ObjectOutputStream oos = new ObjectOutputStream(fos);*/
        //创建序列化流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"));
        //调用了写入对象的方法,写入对象信息
        oos.writeObject(new Person("zhangsan",23));
        oos.writeObject(new Person("lili",25));
        //关闭流
        oos.close();
    }
}
