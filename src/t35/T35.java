package t35;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * <p>
 * 示例2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * <p>
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * 示例 4:
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 * <p>
 * 示例 5:
 * 输入: nums = [1], target = 0
 * 输出: 0
 */
public class T35 {
    public int searchInsert(int[] nums, int target) {
//        int n = nums.length;
//        int left = 0, right = n - 1, ans = n;
//        while (left <= right) {
//            int mid = ((right - left) >> 1) + left;
//            if (target <= nums[mid]) {
//                ans = mid;
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return ans;

        int n = nums.length;
        int left = 0, right = n - 1, res = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;

//        int num = 0, n = nums.length;
//        for (int i = 0; i < n; i++) {
//            if(target <= nums[i]) {
//                return i;
//            } else {
//                num++;
//            }
//        }
//        return num;
    }

    public static void main(String[] args) {
        T35 t35 = new T35();
        int[] nums = {1, 3, 5, 6};
//        int target = 5;
//        int target = 2;
        int target = 7;
//        int target = 0;
        System.out.println(t35.searchInsert(nums, target));
    }
}
