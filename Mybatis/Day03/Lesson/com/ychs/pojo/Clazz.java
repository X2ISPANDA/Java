/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.pojo;

import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/11/9 9:49
 */
public class Clazz {
    private String cno;
    private String cname;

    private List<Student> students;

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }
}
