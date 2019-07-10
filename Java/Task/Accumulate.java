/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

/**
 * @Description:使用do...while循环实现1~10的累加
 * @Author Mingyu Xiong
 * @Date 2019/07/10 11:31
 */
public class Accumulate {
    public static void main(String[] args) {
        int i = 1;
        int sum = 0;
        do {
            sum += i;
            i++;
        } while (i<=10);
        System.out.println(sum);

    }
}
