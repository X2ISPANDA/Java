/*
 *   All rights Reserved, Designed By Mingyu Xiong
 *
 */

/**
 * @Description:排序算法类的基类
 * @Author Mingyu Xiong
 * @Date 2019/07/13 12:37
 */
public class Example {

    /**
     * 比较大小
     * @param v 比较的第一个数
     * @param w 比较的第二个数
     * @return 若第一个数比第二个数小则返回true，否则返回false
     */
    public static boolean less(Comparable v, Comparable w) {
        //v<b,返回-1；v=b，返回0；v>b，返回1
        return v.compareTo(w) < 0;
    }

    /**
     * 交换数组元素
     * @param a 传入的数组
     * @param i 交换的元素1
     * @param j 交换的元素2
     */
    public void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 在单行中打印数组
     * @param a 传入数组
     */
    public void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
        }
        System.out.println();
    }

    /**
     * 测试数组是否有序
     * @param a 传入数组
     * @return 有序则返回ture
     */
    public boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
