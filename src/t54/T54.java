package t54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class T54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, down = m - 1, left = 0, right = n - 1;
        int num = 0;
        while (left <= right && top <= down) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            if (left < right && top < down) {
                for (int i = right - 1; i > left; i--) {
                    list.add(matrix[down][i]);
                }
                for (int i = down; i > top; i--) {
                    list.add(matrix[i][left]);
                }
            }
            top++;
            right--;
            down--;
            left++;
        }
        /*while (true) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
                num++;
            }
            if (num == m * n) {
                break;
            }
            top++;
            for (int i = top; i <= down; i++) {
                list.add(matrix[i][right]);
                num++;
            }
            if (num == m * n) {
                break;
            }
            right--;
            for (int i = right; i >= left ; i--) {
                list.add(matrix[down][i]);
                num++;
            }
            if (num == m * n) {
                break;
            }
            down--;
            for (int i = down; i >= top; i--) {
                list.add(matrix[i][left]);
                num++;
            }
            if (num == m * n) {
                break;
            }
            left++;
        }*/
        return list;
    }

    public static void main(String[] args) {
        T54 t54 = new T54();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(t54.spiralOrder(matrix));
    }
}
