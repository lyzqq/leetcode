package Molevoting;

/**
 * @author 刘勇志
 * @version 1.0
 */
public class Demo {
    public int majorityElement(int[] nums) {
        int majority = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                majority = num;
                count++;
            } else {
                if (majority == num) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        int counter = 0;
        if (count <= 0) {
            return -1;
        } else {
            for (int num : nums) {
                if (num == majority) counter++;
            }
        }
        if (counter > nums.length / 2) {
            return majority;
        }
        return -1;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        //int[] nums = {1,2,2,3,2,3,3,2,2};
        int[] nums = {1,2,2,3,2,3,3,2,1};
        System.out.println(demo.majorityElement(nums));
    }
}
