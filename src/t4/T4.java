package t4;

/**
 * @author 刘勇志
 * @version 1.0
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 */
public class T4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int length = m + n;
        int left = -1, right = -1;
        int start1 = 0, start2 = 0;
        for (int i = 0; i <= length / 2; i++) {
            left = right;
            if (start1 < m && (start2 >= n || nums1[start1] < nums2[start2])) {
                right = nums1[start1++];
            } else {
                right = nums2[start2++];
            }
        }
        if ((length % 2) == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }


        /* int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2] + nums2[n / 2 - 1]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2] + nums1[m / 2 - 1]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }
        int count = 0;
        int i = 0, j = 0;
        while (count != (m + n)) {
            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }
            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }
        if (count % 2 == 0) {
            return (nums[count / 2] + nums[count / 2 - 1]) / 2.0;
        } else {
            return nums[count / 2];
        }*/
    }

    public static void main(String[] args) {
        T4 t4 = new T4();
        //int[] nums1 = {1, 3};
        //int[] nums2 = {2};
        int[] nums1 = {1, 2, 5};
        int[] nums2 = {3, 4, 5, 6};
        Long start = System.currentTimeMillis();
        System.out.println(t4.findMedianSortedArrays(nums1, nums2));
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
