/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @description:教员实体类
 * @author Mingyu Xiong
 * @date 2019/07/15 10:54
 */
public class Teacher {
    /**
     * 姓名
     */
    private String name;
    /**
     * 专业方向
     */
    private String direction;
    /**
     * 教授科目
     */
    private String subject;
    /**
     * 教龄
     */
    private String years;


    public Teacher(String name, String direction, String subject, String years) {
        this.name = name;
        this.direction = direction;
        this.subject = subject;
        this.years = years;
    }

    public void show() {
        System.out.println(name);
        System.out.println("专业方向：" + direction);
        System.out.println("教授课程：" + subject);
        System.out.println("教龄：" + years);
    }
}
