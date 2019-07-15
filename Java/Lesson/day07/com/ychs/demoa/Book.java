/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demoa;

/**
 * @author Mingyu Xiong
 * @description:教材实体类
 * @date 2019/07/15 16:35
 */
public class Book {
    /**
     * 名称
     */
    private String title;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 种类
     */
    private String type;

    public Book(String title,int pageNum) {
        this.type="计算机";
        this.title = title;
        this.pageNum = pageNum;
    }

    public Book(String title, int pageNum, String type) {
        this.type = type;
        this.title = title;
        this.pageNum = pageNum;
    }

    public void study() {

    }

    public void detail() {
        System.out.println("教材名称：" + title);
        System.out.println("教材页数：" + pageNum);
        System.out.println("教材种类：" + type);
    }
}

