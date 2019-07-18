/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

import java.util.Scanner;

/**
 * @Description:
 * @Author Mingyu Xiong
 * @Date 2019/07/11 16:08
 */
public class ArrayDemo {
    public static void main(String[] args) {
        int a[][] = new int[3][4];
        Scanner scanner = new Scanner(System.in);

        double[] sum = new double[3];
        for (int i = 0; i < a.length; i++) {
            System.out.println("请输入第"+(i+1)+"班的成绩");
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = scanner.nextInt();
                sum[i] += a[i][j];
            }
            System.out.println("第"+(i+1)+"班参赛学员的平均分为：" + sum[i] / 4);
        }


        int sum1 = 0;
        for (int[] ints : a) {
            for (int anInt : ints) {
                if (anInt > 85) {
                    sum1 += 1;
                }
            }
        }
        System.out.println("大於85分的人數為" + sum1);

    }
}
