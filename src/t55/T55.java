package t55;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * <p>
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */
public class T55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int right = 0;
        for (int i = 0; i < n; i++) {
            if (i <= right) {
                right = Math.max(right, i + nums[i]);
                if (right >= n) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        T55 t55 = new T55();
//        int[] nums = {2,3,1,1,4};
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(t55.canJump(nums));

    }
}
