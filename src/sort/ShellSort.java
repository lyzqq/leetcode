package sort;

import java.util.Arrays;

/**
 * @Author Lyz
 * @Date: 2022/3/28 16:14
 * @Version 1.0
 * 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] array = {5, 3, 4, 6, 2, 1, 0};
        System.out.println(Arrays.toString(shellSort(array)));
    }

    private static int[] shellSort(int[] array) {
        int len = array.length;
        int temp;
        for (int step = len / 2; step >= 1; step /= 2) {
            for (int i = step; i < len; i++) {
                temp = array[i];
                int j = i - step;
                while (j >= 0 && array[j] > temp) {
                    array[j + step] = array[j];
                    j -= step;
                }
                array[j + step] = temp;
            }
        }
        return array;
    }
}
