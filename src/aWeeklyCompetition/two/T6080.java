package aWeeklyCompetition.two;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author Lyz
 * @Date: 2022/5/29 11:17
 * @Version 1.0
 * 6080. 使数组按非递减顺序排列 显示英文描述
 * 题目难度Medium
 * 给你一个下标从 0 开始的整数数组 nums 。在一步操作中，移除所有满足 nums[i - 1] > nums[i] 的 nums[i] ，其中 0 < i < nums.length 。
 * <p>
 * 重复执行步骤，直到 nums 变为 非递减 数组，返回所需执行的操作数。
 * <p>
 * 示例 1：
 * 输入：nums = [5,3,4,4,7,3,6,11,8,5,11]
 * 输出：3
 * 解释：执行下述几个步骤：
 * - 步骤 1 ：[5,3,4,4,7,3,6,11,8,5,11] 变为 [5,4,4,7,6,11,11]
 * - 步骤 2 ：[5,4,4,7,6,11,11] 变为 [5,4,7,11,11]
 * - 步骤 3 ：[5,4,7,11,11] 变为 [5,7,11,11]
 * [5,7,11,11] 是一个非递减数组，因此，返回 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,7,7,13]
 * 输出：0
 * 解释：nums 已经是一个非递减数组，因此，返回 0 。
 */
public class T6080 {
    public static int totalSteps(int[] nums) {
        int res = 0;
        if (nums.length == 1) {
            return 0;
        }
        int left = 1, right = 1, maxIndex = 0;
        while (right < nums.length) {
            int tem = 0;
            while (nums[right] < nums[maxIndex]) {
                tem++;
                right++;
                while (right < nums.length && nums[right] < nums[maxIndex] && nums[right] >= nums[left]) {
                    tem++;
                    left++;
                    right++;
                }
                left = right;
                res = Math.max(res, tem);
            }
            maxIndex = right;
            right++;
            left = right;
        }
        return res;
    }
    /*public static int totalSteps(int[] nums) {
        int tem = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        int size = list.size();
        while (size != sort(list).size()) {
            size = sort(list).size();
            list = sort(list);
            tem++;
        }
        return tem;
    }
    private static List<Integer> sort( List<Integer> list) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) >= list.get(i - 1)) {
                list1.add(list.get(i));
            }
        }
        return list1;
    }*/

    public static void main(String[] args) {
//        int[] nums = {5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11};
//        int[] nums = {4, 4, 7};
//        int[] nums = {4, 11, 7, 8, 11};
//        int[] nums = {7, 14, 4, 14, 13, 2, 6, 13};
        int[] nums = {5, 14, 15, 2, 11, 5, 13, 15};
        System.out.println(totalSteps(nums));
    }
}
