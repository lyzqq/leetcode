package jianzioffer1;

import java.util.Arrays;

/**
 * @Author Lyz
 * @Date: 2022/4/13 10:25
 * @Version 1.0
 *
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * 示例 1：
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 */
public class T56One {

    public static int[] singleNumbers(int[] nums) {
        int sum = 0;
        // 得到异或结果，即为不相同两个数的异或结果sum
        for (int num : nums) {
            sum ^= num;
        }
        // 得到sum的二进制的1的最低位
        int flag = (-sum) & sum;
        int[] result = new int[2];
        // 分成两个组进行异或，每组异或后的结果就是不相同两个数的其中之一
        for (int num : nums) {
            if ((flag & num) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,4,6};
        System.out.println(Arrays.toString(singleNumbers(nums)));
    }
}
