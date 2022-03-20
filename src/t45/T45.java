package t45;

/**
 * @author 刘勇志
 * @version 1.0
 * 45. 跳跃游戏 II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 */
public class T45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int right = 0;
        int end = 0;
        int steps = 0;
        for (int i = 0; i < n - 1; i++) {
            right = Math.max(right, i + nums[i]);
            if (i == end) {
                end = right;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        T45 t45 = new T45();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(t45.jump(nums));
    }
}
