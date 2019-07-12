/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

import java.util.Arrays;

/**
 * @Description:插入排序
 * @Author Mingyu Xiong
 * @Date 2019/07/12 11:16
 */
public class InsertSort {
    public static void main(String[] args) {
        int a[] = {5, 4, 8, 7, 9, 3};
        InsertSort insertSort = new InsertSort();
        System.out.println(Arrays.toString(insertSort.insertSort(a)));
    }

    public int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j;
            int temp = arr[i];
            for (j = i; j >0; j--) {
                if (arr[j-1] > temp) {
                    arr[j] = arr[j-1];
                } else {
                    break;
                }

            }
            arr[j] = temp;
        }
        return arr;
    }

}
