package com.ychs.demo;

import java.util.Scanner;

/**
 * @Description:读取一个人的姓名，工作小时数，每小时的工资，税率，输出该员工的相关信息
 * @Author Mingyu Xiong
 * @Date 2019/07/09 14:49
 */
public class Worker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("請輸入你的名字：");
        String name = sc.nextLine();
        System.out.println("請輸入你的工作小時數：");
        int hour = sc.nextInt();
        System.out.println("請輸入你的每小時工資：");
        int wage = sc.nextInt();
        System.out.println("請輸入你的稅率：");
        double shuilv = sc.nextDouble();

        System.out.println(name + "的工作小時數為：" + hour + "," + "每小時工資為：" + wage + "，" + "稅率為：" + shuilv + "。");
    }


}
