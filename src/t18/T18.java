package t18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Lyz
 * @Date: 2022/2/28 11:07
 * @Version 1.0
 * 18. 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 */
public class T18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        if (len < 4) return lists;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j -1]) continue;
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        lists.add(list);
                        while (left < right && nums[left + 1] == nums[left]) {
                            ++left;
                        }
                        while (left < right && nums[right - 1] == nums[right]) {
                            --right;
                        }
                        ++left;
                        --right;
                    } else if (sum < target) {
                        left++;
                    } else {
                        --right;
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        T18 t18 = new T18();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(t18.fourSum(nums, target));
    }
}
