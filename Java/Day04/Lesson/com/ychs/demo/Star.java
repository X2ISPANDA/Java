/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

import java.util.Scanner;

/**
 * @Description:输出各种星星图案
 * @Author Mingyu Xiong
 * @Date 2019/07/10 15:31
 */
public class Star {
    public static void main(String[] args) {
        System.out.print("请输入行数：");
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();

        for (int i = 1; i <= l; i++) {
            for (int j = l - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 1;k<=i;k++ ) {
                System.out.print("* ");
            }
            System.out.println("");
        }

//        请输入行数：5
//                *
//               * *
//              * * *
//             * * * *
//            * * * * *
        System.out.println("-----------------------");
        for (int i = 0; i < l; i++) {
            for (int j = l - i-1; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 1;k<=2*i+1;k++ ) {
                System.out.print("*");
            }
            System.out.println("");
        }
//        请输入行数：5
//                *
//               ***
//              *****
//             *******
//            *********
        System.out.println("-----------------------");


        for (int i = 0; i < l; i++) {
            for (int j = l - i-1; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 1;k<=2*i+1;k++ ) {
                System.out.print("*");
            }
            System.out.println("");
        }

        for (int i = 1; i < l; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int k = 1;k<=2*(l-i-1)+1;k++ ) {
                System.out.print("*");
            }

            System.out.println("");
        }

//        请输入行数：5
//                *
//               ***
//              *****
//             *******
//            *********
//             *******
//              *****
//               ***
//                *
//

    }

}
