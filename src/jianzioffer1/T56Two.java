package jianzioffer1;

/**
 * @Author Lyz
 * @Date: 2022/4/13 10:57
 * @Version 1.0
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * <p>
 * 示例 1：
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 */
public class T56Two {

    public static int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        int[] nums = {9, 1, 7, 9, 7, 9, 7};
        System.out.println(singleNumber(nums));
    }
}
