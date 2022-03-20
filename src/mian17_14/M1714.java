package mian17_14;

import java.util.Arrays;
import java.util.Random;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 面试题 17.14. 最小K个数
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * 示例：
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 */
public class M1714 {
    public int[] smallestK(int[] arr, int k) {
        randomizedSelected(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private void randomizedSelected(int[] arr, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int pos = randomizedPartition(arr, left, right);
        int num = pos - left + 1;
        if (k == num) {
            return;
        } else if (k < num) {
            randomizedSelected(arr, left, pos - 1, k);
        } else {
            randomizedSelected(arr, pos + 1, right, k - num);
        }

    }

    // 基于随机的划分
    private int randomizedPartition(int[] nums, int left, int right) {
        int i = new Random().nextInt(right - left + 1) + left;
        swap(nums, right, i);
        return partition(nums, left, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left - 1;
        for (int j = left; j <= right - 1; ++j) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        int k = 4;
        M1714 m1714 = new M1714();
        System.out.println(m1714.smallestK(arr, k));
    }
}
