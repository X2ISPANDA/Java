/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/15 17:17
 */
public class Demo5 {
}
class ClassA {
    static int count = 0;
    static {
        count++;
        System.out.println("A");
    }
    public ClassA() {
        System.out.println("B");
    }
}
class ClassB {
    static {
        ClassA t2;
        System.out.println("C");
    }
    public static void main(String[] args) {
        Class c1;
        Class c2;
        Class c3;
        try {
            c1 = ClassA.class;
            c2 = Class.forName("ClassA");
            ClassA a = new ClassA();
            c3 = a.getClass();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        if (c2 == c1&& c1 == c3) {
            System.out.println("D");
        } else {
            System.out.println("E");
        }
        System.out.println(ClassA.count);
    }
}
