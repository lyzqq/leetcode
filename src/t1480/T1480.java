package t1480;

import java.util.Arrays;

/**
 * @author 刘勇志
 * @version 1.0
 * 1480. 一维数组的动态和
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * 请返回 nums 的动态和。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 * <p>
 * 示例 2：
 * 输入：nums = [1,1,1,1,1]
 * 输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
 * <p>
 * 示例 3：
 * 输入：nums = [3,1,2,10,1]
 * 输出：[3,4,6,16,17]
 */
public class T1480 {
    public int[] runningSum(int[] nums) {
        int sum = nums[0];
        int n = nums.length;
        int[] res = new int[n];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            sum += nums[i];
            res[i] = sum;
        }
        return res;
    }

    public static void main(String[] args) {
        T1480 t1480 = new T1480();
        int[] nums = {3, 1, 2, 10, 1};
        System.out.println(t1480.runningSum(nums));
    }
}
