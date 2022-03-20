package jianzioffer1;

import java.util.Arrays;

/**
 * @Author Lyz
 * @Date: 2022/3/5 17:47
 * @Version 1.0
 * <p>
 * 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class T29 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null) return null;
        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m * n];
        int top = 0, left = 0, right = n - 1, bottom = m - 1;
        int idx = 0;
        while (true) {
            for (int i = left; i <= right; ++i) {
                res[idx++] = matrix[top][i];
            }
            if (++top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                res[idx++] = matrix[i][right];
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; --i) {
                res[idx++] = matrix[bottom][i];
            }
            if (--bottom < top) {
                break;
            }
            for (int i = bottom; i >= top; --i) {
                res[idx++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        T29 t29 = new T29();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(t29.spiralOrder(matrix)));
    }
}
