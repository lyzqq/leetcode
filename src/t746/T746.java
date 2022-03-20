package t746;

/**
 * @author 刘勇志
 * @version 1.0
 * 746. 使用最小花费爬楼梯
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 * <p>
 * 示例 1：
 * 输入：cost = [10, 15, 20]
 * 输出：15
 * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 * 示例 2：
 * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出：6
 * 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
 */
public class T746 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];

        /* 错误
        int left, res = 0;
        if (cost[0] < cost[1]) {
            left = 0;
        } else {
            left = 1;
        }
        while (left < cost.length - 2) {
            if (cost[left + 1] < cost[left + 2]){
                res += cost[left + 1];
                left++;
            } else {
                res += cost[left + 2];
                left += 2;
            }
        }
        if (left == cost.length - 1) {
            res += Math.min(cost[left - 1], cost[left - 2]);
        }
        return res;*/
    }

    public static void main(String[] args) {
        T746 t746 = new T746();
//        int[] cost = {10, 15, 20};
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(t746.minCostClimbingStairs(cost));
    }
}
