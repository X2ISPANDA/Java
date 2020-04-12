/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

import com.ychs.bean.Person;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/12/21 14:49
 */
public class JSONDemo01 {
    public static void main(String[] args) {
        JSONObject jo = new JSONObject();
        jo.put("name", "zs");
        jo.put("age", 12);
        jo.put("sex", "f");
        System.out.println(jo.toString());

        Person p = new Person("lisi", 20, "m");

        List list = new ArrayList();
        list.add("1");
        list.add("2");
        p.setList(list);
        JSONObject jo1 = JSONObject.fromObject(p);
        System.out.println(jo1.toString());

        Map map = new HashMap();
        map.put("name", "ww");
        map.put("age", 30);
        JSONObject jo2 = JSONObject.fromObject(map);
        System.out.println(jo2.toString());


    }
}
