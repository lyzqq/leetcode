package jianzioffer1;

import java.util.HashSet;

/**
 * @Author Lyz
 * @Date: 2022/3/1 20:28
 * @Version 1.0
 * <p>
 * 剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class T03 {

    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.add(num)) {
                continue;
            } else {
                return num;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        T03 t03 = new T03();
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(t03.findRepeatNumber(nums));
    }
}
