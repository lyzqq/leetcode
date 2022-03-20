package t414;

/**
 * @author 刘勇志
 * @version 1.0
 * 414. 第三大的数
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * 示例 1：
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * 示例 2：
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * 示例 3：
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 */
public class T414 {
    public int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        boolean f = true;
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == Integer.MIN_VALUE && f) {
                flag++;
                f = false;
            }
            if (nums[i] > max1) {
                flag++;
                // 原先第二大的值传递给第三大
                max3 = max2;
                // 原先最大值的值传递给第二大
                max2 = max1;
                // 更新最大值
                max1 = nums[i];
            } else if (nums[i] > max2 && nums[i] < max1) {
                flag++;
                // 原先第二大的值传递给第三大
                max3 = max2;
                // 更新第二大值
                max2 = nums[i];
            } else if (nums[i] > max3 && nums[i] < max2) {
                flag++;
                max3 = nums[i];
            }
        }
        return flag >= 3 ? max3 : max1;
    }

    public static void main(String[] args) {
        T414 t414 = new T414();
        int[] nums = {3, 2, 1};
        System.out.println(t414.thirdMax(nums));
    }
}
