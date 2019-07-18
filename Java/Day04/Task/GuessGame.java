/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

import java.util.Random;
import java.util.Scanner;

/**
 * @Description:猜数字游戏
 * @Author Mingyu Xiong
 * @Date 2019/07/10 21:19
 */
public class GuessGame {
    public static void main(String[] args) {
        Random random = new Random();
        int s = random.nextInt(100);
        System.out.println(s);
        System.out.println("请输入你猜的数（0-100）：");
        Scanner sc = new Scanner(System.in);
        int guess = sc.nextInt();
        while (true) {
            if (guess > s) {
                System.out.print("您输入的数大了！请重新输入：");
                guess = sc.nextInt();
            } else if (guess < s) {
                System.out.print("您输入的数小了！请重新输入：");
                guess = sc.nextInt();
            } else {
                System.out.println("您猜对了！");
                break;
            }
        }

    }
}
