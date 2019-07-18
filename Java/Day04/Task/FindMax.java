/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

import java.util.Scanner;

/**
 * @Description:使用标志控制循环次数，输入任意多个正整数，输入-1停止，找最大的数
 * @Author Mingyu Xiong
 * @Date 2019/07/10 11:00
 */
public class FindMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入任意多个正整数，输入-1停止：");
        int max=0;
        while (true) {
            int a = sc.nextInt();
            if (a > max) {
                max=a;
            }
            if (a == -1) {
                System.out.println(max);
                break;
            }
        }
    }
}
