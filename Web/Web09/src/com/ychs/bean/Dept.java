/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.bean;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/12/21 17:06
 */
public class Dept {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dept() {
    }

    public Dept(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
