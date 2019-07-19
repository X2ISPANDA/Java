/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/18 10:05
 */
public abstract class Bird {
    private String name;
    public abstract String fly();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
