package t47;

import com.sun.xml.internal.txw2.output.DumpSerializer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 刘勇志
 * @version 1.0
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class T47 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        boolean[] used = new boolean[n];
        Arrays.sort(nums);
        backtrack(used, nums, 0, n);
        return ans;
    }

    private void backtrack(boolean[] used, int[] nums, int cur, int n) {
        if (cur == n) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            // 判重, 若使用过该元素则跳过
            if (used[i]) continue;
            /**
             *  剪枝, i>0 是为了让 nums[i-1] 不越界
             正常不剪枝的回溯: 对于每一层回溯搜索, 会判断其它未被使用的所有元素(会有重复的元素), 都被填充到该位置一次;
             剪枝的意思是: 保证相邻的重复元素在每一层的回溯搜索中, 只被回溯搜索填充一个, 其余的不再会填充, 且遵循靠左的第一个未被填充的元素被填充,
             若没有这个剪枝的过程, 那么这些重复的相邻元素, 会被回溯搜索填充cnt(相邻重复元素)次;
             eg: 对于重复的四个元素 [0, 0, 0, 0], (0 表示未填充) 第一层回溯填充第一个0, 第二层回溯第一个0因已被used, 即continue, 第二个0不会被continue, 执行回溯
             [0, 0, 0, 0] -> [1, 0, 0, 0] -> [1, 1, 0, 0] -> [1, 1, 1, 0] -> [1, 1, 1, 1] (1 表示填充)
             */
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            path.add(nums[i]);
            used[i] = true;
            // 进入下一次
            backtrack(used, nums, cur + 1, n);
            // 回到原来状态
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

   /* private void backtrack(List<Integer> path, int[] nums, int idx) {
        if (idx == nums.length - 1) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < nums.length; ++i) {
            if ((i > 0 && nums[i] == nums[i - 1])) continue;
            Collections.swap(path, idx, i);
            backtrack(path, nums,idx + 1);
            Collections.swap(path, idx, i);
        }
    }*/

    public static void main(String[] args) {
        T47 t47 = new T47();
        int[] nums = {1, 1, 2};
        System.out.println(t47.permuteUnique(nums));
    }
}
