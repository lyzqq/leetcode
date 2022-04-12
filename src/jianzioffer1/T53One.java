package jianzioffer1;

/**
 * @Author Lyz
 * @Date: 2022/4/12 20:08
 * @Version 1.0
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 */
public class T53One {

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
//        int mid;
        int count = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else {
                if (nums[right] != target) {
                    right--;
                } else if (nums[left] != target) {
                    left++;
                } else {
                    break;
                }
            }
        }
        count = right - left + 1;
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(search(nums, target));
    }
}
