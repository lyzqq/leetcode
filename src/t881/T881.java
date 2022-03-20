package t881;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 881. 救生艇
 * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit.
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 * <p>
 * 示例 1：
 * 输入：people = [1,2], limit = 3
 * 输出：1
 * 解释：1 艘船载 (1, 2)
 * <p>
 * 示例 2：
 * 输入：people = [3,2,2,1], limit = 3
 * 输出：3
 * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 * <p>
 * 示例 3：
 * 输入：people = [3,5,3,4], limit = 5
 * 输出：4
 * 解释：4 艘船分别载 (3), (3), (4), (5)
 */
public class T881 {
    public int numRescueBoats(int[] people, int limit) {
        int res = 0;
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        while (left <= right) {
//            if (people[left] + people[right] > limit) {
//                right--;
//                res++;
//            } else {
//                left++;
//                right--;
//                res++;
//            }
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        T881 t881 = new T881();
//        int[] people = {1,2};
//        int[] people = {3,5,3,4};
        int[] people = {3, 2, 2, 1};
        int limit = 3;
        System.out.println(t881.numRescueBoats(people, limit));
    }
}
