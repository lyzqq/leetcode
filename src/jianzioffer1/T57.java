package jianzioffer1;

import java.util.Arrays;

/**
 * @Author Lyz
 * @Date: 2022/4/15 20:50
 * @Version 1.0
 * 剑指 Offer 57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * <p>
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * <p>
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 */
public class T57 {
    public static int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                break;
            }
        }
        return new int[] {nums[left], nums[right]};
    }

    public static void main(String[] args) {
        int[] nums = {10, 26, 30, 31, 47, 60};
        int target = 40;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
