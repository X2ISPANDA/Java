/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

import java.util.Arrays;

/**
 * @Description:冒泡排序
 * @Author Mingyu Xiong
 * @Date 2019/07/11 22:47
 */
public class BubbleSort {
    public static void main(String[] args) {
        int a[] = {5, 4, 8, 7, 9, 3};
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println(Arrays.toString(bubbleSort.bubble(a)));
    }

    public int[] bubble(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp;
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
