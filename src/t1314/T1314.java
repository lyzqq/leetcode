package t1314;

import java.util.Arrays;

/**
 * @author 刘勇志
 * @version 1.0
 * 1314. 矩阵区域和
 * 给你一个 m x n 的矩阵 mat 和一个整数 k ，请你返回一个矩阵 answer ，
 * 其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和：
 * i - k <= r <= i + k,
 * j - k <= c <= j + k 且
 * (r, c) 在矩阵内。
 * 示例 1：
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[12,21,16],[27,45,33],[24,39,28]]
 * 示例 2：
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
 * 输出：[[45,45,45],[45,45,45],[45,45,45]]
 */
public class T1314 {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] res = new int[row][col];
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] - dp[i][j] + mat[i][j];
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 左上角坐标
                int r1 = Math.max(i - k, 0);
                int c1 = Math.max(j - k, 0);
                // 右下角坐标
                int r2 = Math.min(i + k, row - 1);
                int c2 = Math.min(j + k, col - 1);
                res[i][j] = dp[r2 + 1][c2 + 1] - dp[r1][c2 + 1] - dp[r2 + 1][c1] + dp[r1][c1];
            }
        }
        return res;
        /*int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r = i - k;
                int c = j - k;
                while (r <= i + k && c <= j + k) {
                    if (r >= 0 && r <= m - 1 && c >= 0 && c <= n - 1) {
                        ans[i][j] += mat[r][c];
                    }
                    r++;
                    c++;
                }
            }
        }
        return ans;*/
    }

    public static void main(String[] args) {
        T1314 t1314 = new T1314();
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 1;
        System.out.println(Arrays.deepToString(t1314.matrixBlockSum(nums, k)));
    }
}
