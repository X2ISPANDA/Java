/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/24 17:02
 */
public class ExamDemo{
    public static void main(String[] args) {
        //Lambda表达式
        TreeSet<Grade> grades = new TreeSet<>((Grade o1, Grade o2) -> o2.getScore() - o1.getScore());
        Grade grade = new Grade();
        grade.setName("周杰伦");
        grade.setScore(0);
        grades.add(grade);
        Grade grade1 = new Grade();
        grade1.setScore(60);
        grade1.setName("张学友");
        grades.add(grade1);
        Grade grade2 = new Grade();
        grade2.setScore(90);
        grade2.setName("刘德华");
        grades.add(grade2);
        System.out.println(grades);
    }

}
