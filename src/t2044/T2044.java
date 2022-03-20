package t2044;

/**
 * @Author Lyz
 * @Date: 2022/3/15 10:59
 * @Version 1.0
 * <p>
 * 2044. 统计按位或能得到最大值的子集数目
 * 给你一个整数数组 nums ，请你找出 nums 子集 按位或 可能得到的 最大值 ，并返回按位或能得到最大值的 不同非空子集的数目 。
 * 对数组 a 执行 按位或 ，结果等于 a[0] OR a[1] OR ... OR a[a.length - 1]（下标从 0 开始）。
 * 示例 1：
 * 输入：nums = [3,1]
 * 输出：2
 * 解释：子集按位或能得到的最大值是 3 。有 2 个子集按位或可以得到 3 ：
 * - [3]
 * - [3,1]
 * <p>
 * 示例 2：
 * 输入：nums = [2,2,2]
 * 输出：7
 * 解释：[2,2,2] 的所有非空子集的按位或都可以得到 2 。总共有 23 - 1 = 7 个子集。
 * <p>
 * 示例 3：
 * 输入：nums = [3,2,1,5]
 * 输出：6
 * 解释：子集按位或可能的最大值是 7 。有 6 个子集按位或可以得到 7 ：
 * - [3,5]
 * - [3,1,5]
 * - [3,2,5]
 * - [3,2,1,5]
 * - [2,5]
 * - [2,1,5]
 */
public class T2044 {

    public int countMaxOrSubsets(int[] nums) {
        int len = nums.length;
        int max = 0;
        for (int num : nums) {
            max |= num;
        }
        return dfs(0, nums, 0, max);
    }

    private int dfs(int curIndex, int[] nums, int curValue, int max) {
        if (curIndex == nums.length) {
            return curValue == max ? 1 : 0;
        }
        return dfs(curIndex + 1, nums, curValue | nums[curIndex], max)
                + dfs(curIndex + 1, nums, curValue, max);
    }

    public static void main(String[] args) {
        T2044 t2044 = new T2044();
        int[] nums = {3, 2, 1, 5};
        System.out.println(t2044.countMaxOrSubsets(nums));
    }
}
