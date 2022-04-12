package sort;

import java.util.Arrays;

/**
 * @Author Lyz
 * @Date: 2022/3/28 15:43
 * @Version 1.0
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {5, 3, 4, 6, 2, 1};
        System.out.println(Arrays.toString(quickSort(array)));
    }

    private static int[] quickSort(int[] array) {
        int len = array.length;
        for (int i = 1; i < array.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没哟狡猾，也就是待排序列已经有序，排序已经完成
            boolean flag = true;
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    flag = false;
                }
            }
        }
        /**
         * 未优化
        for (int i = 0; i < len - 1; ++i) {
            for (int j = i + 1; j < len; ++j) {
                if (array[j] < array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        */
        return array;
    }
}
