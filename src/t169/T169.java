package t169;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1：
 * 输入：[3,2,3]
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 */
public class T169 {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    //    private Map<Integer,Integer> countNums(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            if (!map.containsKey(num)) {
//                map.put(num,1);
//            } else {
//                map.put(num,map.get(num) + 1);
//            }
//        }
//        return map;
//    }
//    public int majorityElement(int[] nums) {
//        Map<Integer,Integer> counts = countNums(nums);
//        Map.Entry<Integer,Integer> majorityEntry = null;
//        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
//            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
//                majorityEntry = entry;
//            }
//        }
//        return majorityEntry.getKey();
//    }
    public static void main(String[] args) {
        T169 t169 = new T169();
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(t169.majorityElement(nums));
    }
}
