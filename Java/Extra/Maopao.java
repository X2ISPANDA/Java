/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

import java.util.Arrays;

/**
 * @author Mingyu Xiong
 * @description:冒泡排序复习
 * @date 2019/10/17 16:26
 */
public class Maopao {
    public static void main(String[] args) {
        int a[] = {55,3,66,44,845,1321,46465,686846,535456,454};
        int[] numbers = {10,20,15,0,6,7,2,1,-5,55};
        System.out.println(Arrays.toString(new Maopao().maopao(a)));
        System.out.println(Arrays.toString(new Maopao().maopao(numbers)));
    }

    public int[] maopao(int[] arr) {
        //遍历的次数
        for(int i=0;i<arr.length-1;i++){
            //从头遍历到尾
            for (int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }


}
