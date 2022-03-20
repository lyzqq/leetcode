package t413;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 413. 等差数列划分
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * 子数组 是数组中的一个连续序列。
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
 * 示例 2：
 * 输入：nums = [1]
 * 输出：0
 */
public class T413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        int d = nums[0] - nums[1], num = 0, ans = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i - 1] - nums[i] == d) {
                num++;
            } else {
                d = nums[i - 1] - nums[i];
                num = 0;
            }
            ans += num;
        }
        /* 可行
        int num = 0, ans = 0;
        int left = 0, right = left + 2;
        while (right < n) {
            int d = nums[left + 1] - nums[left];
            if (nums[right] - nums[right - 1] == d) {
                num++;
                right++;
                ans += num;
            } else {
                left = right - 1;
                right += 1;
                num = 0;
            }
        }*/
        return ans;
    }

    public static void main(String[] args) {
        T413 t413 = new T413();
//        int[] nums = {1, 2, 3, 4};
        int[] nums = {3, -1, -5, -9};
//        int[] nums = {1,3,5,7,9};
//        int[] nums = {1,2,3,8,9,10};
        System.out.println(t413.numberOfArithmeticSlices(nums));
    }
}
