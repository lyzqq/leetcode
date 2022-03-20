package t223;

import java.util.Arrays;

/**
 * @author 刘勇志
 * @version 1.0
 * 223. 矩形面积
 * 给你 二维 平面上两个 由直线构成的 矩形，请你计算并返回两个矩形覆盖的总面积。
 * <p>
 * 每个矩形由其 左下 顶点和 右上 顶点坐标表示：
 * <p>
 * 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
 * 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * Rectangle Area
 * 输入：ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
 * 输出：45
 * 示例 2：
 * <p>
 * 输入：ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
 * 输出：16
 */
public class T223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
//        int[] arr = new int[8];
        int sum1, sum2, sum3, ans;
//        arr[0] = ax1;
//        arr[1] = ax2;
//        arr[2] = bx1;
//        arr[3] = bx2;
//        arr[4] = ay1;
//        arr[5] = ay2;
//        arr[6] = by1;
//        arr[7] = by2;
//        Arrays.sort(arr, 0, 4);
//        Arrays.sort(arr, 4, 8);
        sum1 = (ax1 - ax2) * (ay1 - ay2);
        sum2 = (bx1 - bx2) * (by1 - by2);
        int x1 = Math.max(ax1, bx1);
        int x2 = Math.min(ax2, bx2);
        int y1 = Math.max(ay1, by1);
        int y2 = Math.min(ay2, by2);
        if (ax2 <= bx1 || ax1 >= bx2 || ay2 <= by1 || ay1 >= by2) {
            sum3 = 0;
        }
        /*else if (ax1 <= bx1 && bx2 <= ax2 && ay1 <= by1 && by2 <= ay2) {
            return sum1;
        } else if (ax1 >= bx1 && bx2 >= ax2 && ay1 >= by1 && by2 >= ay2) {
            return sum2;
        }*/
        else {
            sum3 = (x2 - x1) * (y2 - y1);
        }
        ans = sum1 + sum2 - sum3;
        return ans;
    }

    public static void main(String[] args) {
        T223 t223 = new T223();
        int ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2;
//        int ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -3, by1 = 1, bx2 = -1, by2 = 3;
        System.out.println(t223.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
    }
}
