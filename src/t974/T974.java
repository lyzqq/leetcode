package t974;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Lyz
 * @Date: 2022/4/17 21:45
 * @Version 1.0
 * 974. 和可被 K 整除的子数组
 * 给定一个整数数组 nums 和一个整数 k ，返回其中元素之和可被 k 整除的（连续、非空） 子数组 的数目。
 * 子数组 是数组的 连续 部分。
 * 示例 1：
 * 输入：nums = [4,5,0,-2,-3,1], k = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 k = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * 示例 2:
 * 输入: nums = [5], k = 9
 * 输出: 0
 */
public class T974 {

    public static int subArraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, ans = 0;
        for (int num : nums) {
            sum += num;
            // 当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % k + k) % k;
            int same = map.getOrDefault(modulus, 0);
            ans += same;
            map.put(modulus, same + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(subArraysDivByK(nums, k));
    }
}
