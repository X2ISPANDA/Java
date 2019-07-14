/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

import java.util.Arrays;

/**
 * @Description:希尔排序
 * @Author Mingyu Xiong
 * @Date 2019/07/14 22:50
 */
public class ShellSort extends Example{
    public static void main(String[] args) {
        int a[] = {5, 4, 8, 7, 9, 3};
        ShellSort shellSort = new ShellSort();
        System.out.println(Arrays.toString(shellSort.sort(a)));
    }


    public int[] sort(int[] array) {
        int temp;
        for (int k = array.length / 2; k > 0; k /= 2) {//计算K值
            for (int i = k; i < array.length; i++) {
                for (int j = i; j >= k; j -= k) {
                    if (array[j - k] > array[j]) {
                        exch(array, j - k, j);
                    }
                }
            }
        }
        return array;
    }
}
