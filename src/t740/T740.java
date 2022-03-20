package t740;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 740. 删除并获得点数
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。
 * 之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * 示例 1：
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * 示例 2：
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 */
public class T740 {
    public int deleteAndEarn(int[] nums) {
        int numMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > numMax) {
                numMax = nums[i];
            }
        }
        int[] temp = new int[numMax + 1];
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]] += nums[i];
        }
        int first = temp[0];
        int second = Math.max(temp[0], temp[1]);
        for (int i = 2; i < temp.length; i++) {
            int tem = second;
            second = Math.max(first + temp[i], second);
            first = tem;
        }
        return second;
    }

    public static void main(String[] args) {
        T740 t740 = new T740();
        int[] nums = {3, 4, 2};
        System.out.println(t740.deleteAndEarn(nums));
    }
}
