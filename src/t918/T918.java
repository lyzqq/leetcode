package t918;

import java.awt.*;
import java.util.ArrayDeque;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 918. 环形子数组的最大和
 * 给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。
 * 在此处，环形数组意味着数组的末端将会与开头相连呈环状。（形式上，当0 <= i < A.length
 * 时 C[i] = A[i]，且当 i >= 0 时 C[i+A.length] = C[i]）
 * 此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。（形式上，对于子数组 C[i], C[i+1], ..., C[j]，
 * 不存在 i <= k1, k2 <= j 其中 k1 % A.length = k2 % A.length）
 * 示例 1：
 * 输入：[1,-2,3,-2]
 * 输出：3
 * 解释：从子数组 [3] 得到最大和 3
 * 示例 2：
 * 输入：[5,-3,5]
 * 输出：10
 * 解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
 * 示例 3：
 * 输入：[3,-1,2,-1]
 * 输出：4
 * 解释：从子数组 [2,-1,3] 得到最大和 2 + (-1) + 3 = 4
 * 示例 4：
 * 输入：[3,-2,2,-3]
 * 输出：3
 * 解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
 * 示例 5：
 * 输入：[-2,-3,-1]
 * 输出：-1
 * 解释：从子数组 [-1] 得到最大和 -1
 */
public class T918 {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] d2 = new int[2 * n + 1];
        for (int i = 0; i < 2 * n; i++) {
            d2[i + 1] = nums[i % n] + d2[i];
        }
        int res = d2[0];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);

        for (int i = 1; i < 2 * n; i++) {
            if (deque.peekFirst() < i - n) {
                deque.pollFirst();
            }
            res = Math.max(res, d2[i] - d2[deque.peekFirst()]);
            while (!deque.isEmpty() && d2[i] <= d2[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return res;

        /*失败
        int n = nums.length;
        if (n == 1) {
            return  nums[0];
        }
        int[] d2 = new int[2*n];
        for (int i = 0; i < 2 * n; i++) {
            d2[i] = nums[i % n];
        }
        int res = 0, sum = 0;
        for (int i = 0; i < d2.length; i++) {
            if (i >= n) {
                sum -= d2[i];
            }
            sum = Math.max(d2[i] + sum, sum);
            res = Math.max(sum,res);
        }
        return res;*/
    }

    public static void main(String[] args) {
        T918 t918 = new T918();
        int[] nums = {3, -1, 2, -1};
        System.out.println(t918.maxSubarraySumCircular(nums));
    }
}
