package com.ychs.pojo;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/4/6 12:51
 */
public class Phone {
    private int id;
    private String type;

    public Phone() {
    }

    public Phone(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
