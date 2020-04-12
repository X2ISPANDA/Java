/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.task.bean;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/29 20:40
 */
public class Clazz {
    private String cno;
    private String cname;
    private String cmanager;

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

    public String getCmanager() {
        return cmanager;
    }

    public void setCmanager(String cmanager) {
        this.cmanager = cmanager;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", cmanager='" + cmanager + '\'' +
                '}';
    }
}
