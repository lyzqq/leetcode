package jianzioffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Lyz
 * @Date: 2022/3/1 16:18
 * @Version 1.0
 * 剑指 Offer II 004. 只出现一次的数字
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。
 * 请你找出并返回那个只出现了一次的元素。
 * <p>
 * 示例 1：
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 * 输入：nums = [0,1,0,1,0,1,100]
 * 输出：100
 * <p>
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 * 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class T004 {
    public int singleNumber(int[] nums) {
        /**
         * 不适用额外空间
         */
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                res += (1 << i);
            }
        }
        return res;
        /**
         * 使用HashMap额外空间

         HashMap<Integer, Integer> map = new HashMap<>();
         for (int num : nums) {
         map.put(num, map.getOrDefault(num, 0) + 1);
         }
         int res = 0;
         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
         int num = entry.getKey(), value = entry.getValue();
         if (value == 1) {
         res = num;
         break;
         }
         }
         return res;
         */
    }

    public static void main(String[] args) {
        T004 t004 = new T004();
//        int[] nums = {2, 2, 3, 2};
        int[] nums = {0,1,0,1,0,1,100};
        System.out.println(t004.singleNumber(nums));
    }
}
