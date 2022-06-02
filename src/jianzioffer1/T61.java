package jianzioffer1;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Lyz
 * @Date: 2022/4/16 12:01
 * @Version 1.0
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * 示例 2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 */
public class T61 {
    public static boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) continue; // 跳过大小王
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if (set.contains(num)) return false;// 如有重复的，返回false
            set.add(num); // 添加牌到Set
        }
        // 最大牌 - 最小牌 < 5 则可构成顺子
        return max - min < 5;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(isStraight(nums));
    }
}
