package t11;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n
 * 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，
 * 使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * <p>
 * 示例 4：
 * 输入：height = [1,2,1]
 * 输出：2
 */
public class T11 {
    public int maxArea(int[] height) {

        /*
        int maxArea = 0;
        // 代表第一个点的坐标
        for (int i = 0; i < height.length; i++) {
            // 代表第二个点的坐标
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * (Math.min(height[i], height[j]));
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
        */

        /*
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        // 当左指针位于右指针的左边时就一直移动，直到重合，结束循环
        while (i < j) {
            int area = (j - i) * (height[i] < height[j] ? height[i++] : height[j--]);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
         */


        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int left = height[i];
            int right = height[j];
            int tempArea = (j - i) * (Math.min(left, right));
            maxArea = Math.max(tempArea, maxArea);
            //优化如果移动后的指针比之前小就继续移动
            if (left <= right) {
                while (left >= height[++i] && i < j) {
                    left = height[i];
                }
            } else {
                while (right >= height[--j] && i < j) {
                    right = height[j];
                }
            }
        }
        return maxArea;

        /*
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
        */
    }


    public static void main(String[] args) {
        T11 t11 = new T11();
//        int[] height = {4,3,2,1,4};
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(t11.maxArea(height));
    }
}
