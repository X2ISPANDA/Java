/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;
import java.util.Arrays;

/**
 * @Description:
 * @Author Mingyu Xiong
 * @Date 2019/07/10 10:41
 */
public class TrafficDemo {
    public static void main(String[] args) {
        //输出的是数组的首地址
        System.out.println(TrafficLight.values());
        int[] a={1,2,3};
        //输出数组的正确姿势
        System.out.println(Arrays.toString(a));

        //数组的遍历
        for (int i : a) {
            System.out.println(i);
        }
        System.out.println(Arrays.toString(TrafficLight.values()));
        //增强型for循环
        for (TrafficLight light : TrafficLight.values()) {
            System.out.println(light.ordinal() + "," + light.name());
        }
    }
}
