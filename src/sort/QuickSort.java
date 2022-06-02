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
        quick(array, 0, len - 1);
        System.out.println(Arrays.toString(array));
    }

    private static int[] quick(int[] nums, int l, int h) {
        if (l >= h) {
        } else {
            int p = partition(nums, l, h);
            quick(nums, l, p - 1);
            quick(nums, p + 1, h);
        }
        return nums;
    }
    // 双边

    private static int partition(int[] nums, int l, int h) {
        // 设定基准值
        int pv = nums[l];
        int i = l;
        int j = h;
        while (i < j) {
            // j从右找小的
            while (i < j && nums[j] > pv) {
                j--;
            }
            // i从左找大的
            while (i < j && nums[i] <= pv) {
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, l, i);
        return j;
    }

    /*单边
    private static int partition(int[] nums, int l, int h) {
        // 设定基准值
        int pv = nums[h];
        int i = l;
        for (int j = l; j < h; j++) {
            if (nums[j] < pv) {
                if (i != j) {
                    swap(nums, i, j);
                }
                i++;
            }
        }
        if (i != h) {
            swap(nums, i, h);
        }
        return i;
    }
    */



    /*单边排序

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
                if (i != index) {
                    swap(array, i, index);
                }
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
        */

        /*swap(array, pivot, index - 1);
        return index - 1;
        if (index != pivot) {
            swap(array, index, pivot);
        }
        return index;
    }
    */

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
