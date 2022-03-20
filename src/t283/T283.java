package t283;

import java.util.Arrays;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class T283 {

    public void moveZeroes(int[] nums) {
        int left = 0, right = 0, n = nums.length;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
        System.out.println(Arrays.toString(nums));
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    //        int right = nums.length - 1;
//        for (int i = right; i >= 0; i--) {
//            if(nums[i] == 0) {
//                swap(nums,i);
//            }
//        }
//        System.out.println(Arrays.toString(nums));
//    }
//    public void swap(int[] nums, int n) {
//        for (int i = n; i < nums.length - 1; i++) {
//            int temp = nums[i + 1];
//            nums[i + 1] = nums[i];
//            nums[i] = temp;
//        }
//    }
    public static void main(String[] args) {
        T283 t283 = new T283();
        int[] nums = {0, 1, 0, 3, 12};
        t283.moveZeroes(nums);
    }
}
