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
 * @Description:选择排序
 * @Author Mingyu Xiong
 * @Date 2019/07/11 16:51
 */
public class SelectionSort {
    //从数组中选择最小元素，将它与数组的第一个元素交换位置。
    // 再从数组剩下的元素中选择出最小的元素，将它与数组的第二个元素交换位置。
    // 不断进行这样的操作，直到将整个数组排序。

    public static void main(String[] args) {
        int a[] = {5, 4, 8, 7, 9, 3};
        SelectionSort selectionSort = new SelectionSort();
        System.out.println(Arrays.toString(selectionSort.selectSort(a)));
    }

    public int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 用来记录最小值的索引位置，默认值为i
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    // 遍历 i+1~length 的值，找到其中最小值的位置
                    minIndex = j;

                }
            }
            // 交换当前索引 i 和最小值索引 minIndex 两处的值
            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
            // 执行完一次循环，当前索引 i 处的值为最小值，直到循环结束即可完成排序
        }
        return arr;
    }

}
