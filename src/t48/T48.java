package t48;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 48. 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * 示例 2：
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * 示例 3：
 * 输入：matrix = [[1]]
 * 输出：[[1]]
 * 示例 4：
 * 输入：matrix = [[1,2],[3,4]]
 * 输出：[[3,1],[4,2]]
 */
public class T48 {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                /*int temp1 = matrix[0][j];
                int temp2 = matrix[j][m - 1];
                int temp3 = matrix[m - 1][n - 1 - j];
                matrix[0][j] = matrix[m - 1 - j][0];
                matrix[j][m - 1] = temp1;
                matrix[m - 1][n - 1 - j] = temp2;
                matrix[m - 1 - j][0] = temp3;*/
                int temp1 = matrix[i][j];
                matrix[i][j] = matrix[m - 1 - j][i];
                matrix[m - 1 - j][i] = matrix[m - 1 - i][n - 1 - j];
                matrix[m - 1 - i][n - 1 - j] = matrix[j][m - 1 - i];
                matrix[j][m - 1 - i] = temp1;
            }
        }

//        System.out.println(Arrays.asList(matrix));
    }

    public static void main(String[] args) {
        T48 t48 = new T48();
//        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        t48.rotate(matrix);
    }
}
