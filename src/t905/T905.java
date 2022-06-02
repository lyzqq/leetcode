package t905;

import java.util.Arrays;

/**
 * @Author Lyz
 * @Date: 2022/4/28 21:44
 * @Version 1.0
 * 905. 按奇偶排序数组
 * 给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
 * 返回满足此条件的 任一数组 作为答案。
 * <p>
 * 示例 1：
 * 输入：nums = [3,1,2,4]
 * 输出：[2,4,3,1]
 * 解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[0]
 */
public class T905 {
    public static int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (nums[left] % 2 == 0 && left < right) {
                left++;
            }
            while (nums[right] % 2 == 1 && left < right) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4, 5, 6, 3, 7, 9, 8};
        System.out.println(Arrays.toString(sortArrayByParity(nums)));
    }
}
