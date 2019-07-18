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
            //使用中间变量temp记录arr[i]的值
            int temp = arr[i];
            //遍历数组的前i项
            for (j = i; j >0; j--) {
                if (arr[j-1] > temp) {
                    //如果比temp记录的值要大，则让它的值向后移一位
                    arr[j] = arr[j-1];
                } else {
                    break;
                }
            }
            //直到arr[j]<=temp记录的值就将重复的值给换成temp
            arr[j] = temp;
        }
        return arr;
    }

}

