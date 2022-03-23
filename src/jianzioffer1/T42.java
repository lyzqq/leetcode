package jianzioffer1;

/**
 * @Author Lyz
 * @Date: 2022/3/22 22:08
 * @Version 1.0
 */
public class T42 {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int res = nums[0], sum = 0;
        for (int num : nums) {
            sum = Math.max(sum + num, num);
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String[] args) {
        T42 t42 = new T42();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(t42.maxSubArray(nums));
    }
}
