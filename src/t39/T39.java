package t39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 刘勇志
 * @version 1.0
 * 39. 组合总和
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
 * <p>
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7
 * 输出: [[7],[2,2,3]]
 * 示例 2：
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3:
 * 输入: candidates = [2], target = 1
 * 输出: []
 * 示例 4：
 * 输入: candidates = [1], target = 1
 * 输出: [[1]]
 * 示例 5：
 * 输入: candidates = [1], target = 2
 * 输出: [[1,1]]
 */
public class T39 {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, path, target, 0, 0);
        return ans;
    }

    private void backtrack(int[] candidates, List<Integer> path, int target, int sum, int begin) {
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; ++i) {
            int rs = sum + candidates[i];
            if (rs <= target) {
                path.add(candidates[i]);
                backtrack(candidates, path, target, rs, i);
                path.remove(path.size() - 1);
            } else break;
        }
    }

    /**
     * public List<List<Integer>> combinationSum(int[] candidates, int target) {
     * List<List<Integer>> ans = new ArrayList<>();
     * Arrays.sort(candidates);
     * backtrack(candidates, target, ans, 0, new ArrayList<Integer>());
     * return ans;
     * }
     * <p>
     * private void backtrack(int[] candidates, int target, List<List<Integer>> ans, int i, ArrayList<Integer> tmp_list) {
     * if (i == candidates.length) return;
     * if (target == 0) {
     * ans.add(new ArrayList<>(tmp_list));
     * return;
     * }
     * backtrack(candidates, target, ans, i + 1, tmp_list);
     * if (target - candidates[i] >= 0) {
     * tmp_list.add(candidates[i]);
     * backtrack(candidates, target - candidates[i], ans, i, tmp_list);
     * tmp_list.remove(tmp_list.size() - 1);
     * }
     * for (int start = i; start < candidates.length; start++) {
     * if (target < 0) break;
     * tmp_list.add(candidates[start]);
     * backtrack(candidates, target - candidates[start], ans, start, tmp_list);
     * tmp_list.remove(tmp_list.size() - 1);
     * }
     * }
     */

    public static void main(String[] args) {
        T39 t39 = new T39();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(t39.combinationSum(candidates, target));
    }
}
