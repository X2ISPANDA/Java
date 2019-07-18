/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demoa;

import java.util.Scanner;

/**
 * @author Mingyu Xiong
 * @description:游人实体类
 * @date 2019/07/15 17:11
 */
public class Visitor {
    private String name;
    private int age;

    public void price() {
        for (; ; ) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入姓名：");
            this.name=scanner.next();
            if (this.name.equals("n")) {
                System.out.println("程序結束");
                break;
            }
            System.out.print("请输入年龄：");
            this.age = scanner.nextInt();
            String  price=this.age<12?"门票免费。":"门票价格为：20元。";
            System.out.println(this.name+"的年龄为："+this.age+"，"+price);
        }

    }
}
