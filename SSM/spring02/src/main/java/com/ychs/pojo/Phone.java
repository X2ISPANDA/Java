package com.ychs.pojo;

import org.springframework.stereotype.Component;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/4/7 21:15
 */
@Component(value = "phone")
public class Phone {

    private int id;
    private String name;
    private String num;

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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", num='" + num + '\'' +
                '}';
    }
}
