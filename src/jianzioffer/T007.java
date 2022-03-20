package jianzioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Lyz
 * @Date: 2022/3/1 18:55
 * @Version 1.0
 * <p>
 * 剑指 Offer II 007. 数组中和为 0 的三个数
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 不重复 的三元组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 */
public class T007 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        if (len < 3 || nums[0] > 0 || nums[len - 1] < 0) return lists;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    ++left;
                } else if (sum > 0){
                    --right;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    while (left < right && nums[left + 1] == nums[left]){
                        ++left;
                    }
                    while (left < right && nums[right - 1] == nums[right]) {
                        --right;
                    }
                    ++left;
                    --right;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        T007 t007 = new T007();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(t007.threeSum(nums));
    }
}
