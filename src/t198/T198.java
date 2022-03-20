package t198;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class T198 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums[0];
        }
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
//        int[] res = new int[n];
//        // 第一个偷的钱只能是第一家
//        res[0] = nums[0];
//        // 前面两家时只能偷一家的钱，选择其中多的
//        res[1] = Math.max(nums[0],nums[1]);
//        for (int i = 2; i < n; i++) {
//            // 依次遍历，到第i家时，考虑时投i号房子还是不投
//            res[i] = Math.max(res[i - 2] + nums[i], res[i - 1]);
//        }
//        return res[n - 1];
    }

    public static void main(String[] args) {
        T198 t198 = new T198();
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(t198.rob(nums));
    }
}
