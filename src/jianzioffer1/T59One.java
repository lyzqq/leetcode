package jianzioffer1;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author Lyz
 * @Date: 2022/4/16 11:10
 * @Version 1.0
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 */
public class T59One {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList<>();
        // 结果数组
        int[] result = new int[nums.length - k + 1];
        // 遍历nums数组
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if (queue.peek() <= i - k) {
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[queue.peek()];
            }
        }
        return result;
        /** 暴力
         int len = nums.length;
         if (len == 0) {
         return new int[]{};
         }
         int[] res = new int[len - k + 1];
         //        int max = 0;
         for (int i = 0; i < len - k + 1; i++) {
         int tem = Integer.MIN_VALUE;
         for (int j = i; j < i + k; j++) {
         tem = Math.max(tem, nums[j]);
         }
         //            max = Math.max(tem, max);
         res[i] = tem;
         }
         return res;*/
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
//        int[] nums = {1, -1};
        int k = 3;
//        int k = 1;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
}
