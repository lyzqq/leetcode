package sort;

import java.util.Arrays;

/**
 * @Author Lyz
 * @Date: 2022/3/28 15:55
 * @Version 1.0
 * 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {5, 3, 4, 6, 2, 1};
        System.out.println(Arrays.toString(selectionSort(array)));
    }

    private static int[] selectionSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; ++i) {
            int min = i;
            // 每轮需要比较的次数 N - i
            for (int j = i + 1; j < len; ++j) {
                if (array[j] < array[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }
            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = array[i];
                array[i] = array[min];
                array[min] = tmp;
            }
        }

        return array;
    }
}
