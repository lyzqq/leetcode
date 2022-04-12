package sort;

import java.util.Arrays;

/**
 * @Author Lyz
 * @Date: 2022/3/28 17:03
 * @Version 1.0
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {5, 3, 4, 6, 2, 1, 0};
        int len = array.length;
        System.out.println(Arrays.toString(quickSort(array, 0, len - 1)));
    }

    private static int[] quickSort(int[] array, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(array, left, right);
            quickSort(array, left, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, right);
        }
        return array;
    }

    private static int partition(int[] array, int left, int right) {
        // 设定基准值(pivot)
        int pivot = right;

        int index = left;
        for (int i = left; i < right; i++) {
            if (array[i] < array[pivot]) {
                swap(array, i, index);
                index++;
            }
        }
        /*int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (array[i] < array[pivot]) {
                swap(array, i, index);
                index++;
            }
        }
        swap(array, pivot, index - 1);
        return index - 1;*/
        swap(array, index, pivot);
        return index;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
