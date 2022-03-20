package t229;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘勇志
 * @version 1.0
 */
public class T229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int element1 = 0;
        int element2 = 0;
        int vote1 = 0;
        int vote2 = 0;
        for (int num : nums) {
            if (vote1 > 0 && num == element1) {
                vote1++;
            } else if (vote2 > 0 && num == element2) {
                vote2++;
            } else if (vote1 == 0) {
                element1 = num;
                vote1++;
            } else if (vote2 == 0) {
                element2 = num;
                vote2++;
            } else {
                vote1--;
                vote2--;
            }
        }
        int count1 = 0;
        int count2 = 0;
        for (int num : nums) {
            if (vote1 > 0 && num == element1) {
                count1++;
            }
            if (vote2 > 0 && num == element2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            list.add(element1);
        }
        if (count2 > nums.length / 3) {
            list.add(element2);
        }
        return list;
    }

    public static void main(String[] args) {
        T229 t229 = new T229();
        int[] nums = {1,1,1,3,3,2,2,2};
        System.out.println(t229.majorityElement(nums));
    }
}
