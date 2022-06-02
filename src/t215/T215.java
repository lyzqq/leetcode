package t215;

import java.util.Random;

/**
 * @Author Lyz
 * @Date: 2022/4/18 10:31
 * @Version 1.0
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */
public class T215 {

    private static Random random = new Random(System.currentTimeMillis());

    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;
        int left = 0, right = len - 1;
        while (true) {
            int index = partition(nums, left, right);
            if (index < target) {
                left = index + 1;
            } else if (index > target){
                right = index - 1;
            } else {
                return nums[index];
            }
        }
    }

    private static int partition(int[] nums, int left, int right) {
        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(nums, left, randomIndex);
        }

        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, left, j);
        return j;
    }

    private static void swap(int[] nums, int i, int r) {
        int tem = nums[i];
        nums[i] = nums[r];
        nums[r] = tem;
    }

    /*
    public static Random random = new Random();

    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSelect(int[] nums, int l, int r, int index) {
        int q = randomPartition(nums, l, r);
        if (q == index) {
            return nums[q];
        } else {
            return q < index ? quickSelect(nums, q + 1, r, index) : quickSelect(nums, l, q - 1, index);
        }
    }

    private static int randomPartition(int[] nums, int l, int r) {
        int i = random.nextInt(r - l + 1) + 1;
        swap(nums, i, r);
        return partition(nums, l, r);
    }

    private static int partition(int[] nums, int l, int r) {
        int x = nums[r], i = l - 1;
        for (int j = l; j < r; j++) {
            if (nums[j] < x) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private static void swap(int[] nums, int i, int r) {
        int tem = nums[i];
        nums[i] = nums[r];
        nums[r] = tem;
    }*/

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }
}
