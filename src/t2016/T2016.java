package t2016;

/**
 * @Author Lyz
 * @Date: 2022/2/27 10:54
 * @Version 1.0
 */
public class T2016 {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int left = 0, right = 1, res = -1;
        while (right < n) {
            if (nums[left] < nums[right]) {
                res = Math.max(res, nums[right] - nums[left]);
            } else {
                left = right;
            }
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        T2016 t2016 = new T2016();
        int[] nums = {7, 1, 5, 4};
        System.out.println(t2016.maximumDifference(nums));
    }
}
