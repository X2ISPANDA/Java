/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package bean;

import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/27 10:21
 */
public class Clazz {
    private String cno;
    private String cname;

    private List<Student> student;

    //List<Clazz>

    public Clazz() {
    }

    public Clazz(String cno, String cname) {
        this.cno = cno;
        this.cname = cname;
    }

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
