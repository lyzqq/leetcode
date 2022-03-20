package t350;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 */
public class T350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
//        int m = nums1.length, n = nums2.length;
//        int size = Math.min(m, n);
//        int[] res = new int[size];
//        int k = 0;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (nums1[i] == nums2[j]) {
//                    res[k] = nums2[j];
//                    k++;
//                    if (k == size) {
//                        return Arrays.copyOfRange(res,0,k);
//                    }
//                    break;
//                }
//            }
//        }
//        return Arrays.copyOfRange(res,0,k);

    public static void main(String[] args) {
        T350 t350 = new T350();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(t350.intersect(nums1, nums2)));
    }
}
