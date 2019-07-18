/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @Description:学员和教员测试类
 * @Author Mingyu Xiong
 * @Date 2019/07/15 10:57
 */
public class TestTrain {
    public static void main(String[] args) {
        Trainee tr1 = new Trainee();
        tr1.setAge(15);
        tr1.setClazz("Java1班");
        tr1.setName("肖浩锋");
        tr1.setHobby("睡觉");
        tr1.show();

        Teacher t1 = new Teacher("苍老师", "软件工程", "数据结构", "8");
        t1.show();
    }
}
