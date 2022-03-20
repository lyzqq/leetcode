package t46;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 */
public class T46 {
    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>(n);
        boolean[] used = new boolean[n];
        int count = 0;
        backtrace(list, used, count, nums);
        return lists;
    }

    public void backtrace(List<Integer> list, boolean[] used, int count, int[] nums) {
        if (count == nums.length) {
            lists.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                backtrace(list, used, count + 1, nums);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }
   /* public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        int n = nums.length;
        backtrack(n, output, ans, 0);
        return ans;
        *//**
         List<List<Integer>> ans = new ArrayList<>();
         List<Integer> output = new ArrayList<>();
         for (int num : nums) {
         output.add(num);
         }
         int n = nums.length;
         backtrack(n, output, ans, 0);
         return ans;*//*
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> ans, int first) {
        if (first == n) {
            ans.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(output, first, i);
            backtrack(n, output, ans, first + 1);
            Collections.swap(output, first, i);
        }
        *//**
         * // 所有的数都填完了
         if (first == n) {
         ans.add(new ArrayList<>(output));
         }
         for (int i = first; i < n; i++) {
         // 动态维护数组
         Collections.swap(output, first, i);
         // 继续递归填下一个数
         backtrack(n, output, ans, first + 1);
         // 撤销操作
         Collections.swap(output, first, i);
         }*//*
    }*/

    public static void main(String[] args) {
        T46 t46 = new T46();
        int[] nums = {1, 2, 3, 4};
        System.out.println(t46.permute(nums));
    }
}
