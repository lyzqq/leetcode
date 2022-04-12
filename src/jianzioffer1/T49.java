package jianzioffer1;

/**
 * @Author Lyz
 * @Date: 2022/4/12 15:52
 * @Version 1.0
 * 剑指 Offer 49. 丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 * 1 是丑数。
 * n 不超过1690。
 */
public class T49 {

    public static int nthUglyNumber(int n) {
        if (n <= 0) return -1;
        int[] dp = new int[n];
        dp[0] = 1;
        int id2 = 0, id3 = 0, id5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[id2] * 2, Math.min(dp[id3] * 3, dp[id5] * 5));
            // 不用else if 的原因时有可能 id2(3) * 2 == id3(2) * 3
            // 这种情况两个指针都要后移
            if (dp[id2] * 2 == dp[i]) {
                id2 += 1;
            }
            if (dp[id3] * 3 == dp[i]) {
                id3 += 1;
            }
            if (dp[id5] * 5 == dp[i]) {
                id5++;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(nthUglyNumber(n));
    }
}
