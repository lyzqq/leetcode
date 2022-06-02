package t713;

/**
 * @Author Lyz
 * @Date: 2022/5/6 21:05
 * @Version 1.0
 * 713. 乘积小于 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 * <p>
 * 示例 1：
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 * 示例 2：
 * 输入：nums = [1,2,3], k = 0
 * 输出：0
 */
public class T713 {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length, res = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
}
