package t240;

/**
 * @author 刘勇志
 * @version 1.0
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * 示例 2：
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 */
public class T240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = 0;
        int n = matrix[0].length - 1;
        while (m < matrix.length && n >= 0) {
            if (matrix[m][n] == target) {
                return true;
            } else if (matrix[m][n] > target) {
                n--;
            } else {
                m++;
            }
        }
        return false;

        /*int m = matrix.length;
        int n = matrix[0].length;
        int row = 0, col = 0;
        for (int i = 0; i < m; i++) {
            if (target > matrix[0][i]) {
                col = i;
                continue;
            } else if ((target == matrix[0][i])) {
                return true;
            } else {
                col = i - 1;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (target > matrix[i][0]) {
                row = i;
                continue;
            } else if ((target == matrix[i][0])) {
                return true;
            } else {
                row = i - 1;
                break;
            }
        }
        for (int i = 1; i <= row; i++) {
            for(int j = 1; j <= col; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;*/
    }

    public static void main(String[] args) {
        //int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int[][] matrix = {{1, 1}};
        //int target = 5;
        int target = 2;
        //int target = 23;
        T240 t240 = new T240();
        System.out.println(t240.searchMatrix(matrix, target));
    }
}
