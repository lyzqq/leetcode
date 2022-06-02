package t396;

/**
 * @Author Lyz
 * @Date: 2022/4/22 16:10
 * @Version 1.0
 *
 * 396. 旋转函数
 * 给定一个长度为 n 的整数数组 nums 。
 * 假设 arrk 是数组 nums 顺时针旋转 k 个位置后的数组，我们定义 nums 的 旋转函数F为：
 * F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
 * 返回 F(0), F(1), ..., F(n-1)中的最大值 。
 * 生成的测试用例让答案符合 32 位 整数。
 * 示例 1:
 * 输入: nums = [4,3,2,6]
 * 输出: 26
 * 解释:
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * 所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
 * 示例 2:
 * 输入: nums = [100]
 * 输出: 0
 *
 * 4    3     2       6
 * 0*4  1*3   2*2     3*6   F(0)
 * 1*4  2*3   3*2     0*6   F(1) = F(0) + sum(data) - n * data[len - 1]
 * 2*4  3*3   0*2     1*6   F(2) = F(1) + sum(data) - n * data[len - 2]
 * 3*4  0*3   1*2     2*6   F(3) = F(2) + sum(data) - n * data[len - 3]
 */
public class T396 {

    public static int maxRotateFunction(int[] nums) {
        int res, n = nums.length;
        int sum = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            dp[0] += i * nums[i];
        }
        res = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + sum - n * nums[n - i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 6};
        System.out.println(maxRotateFunction(nums));
    }
}
