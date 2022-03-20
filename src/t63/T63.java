package t63;

/**
 * @author 刘勇志
 * @version 1.062. 不同路径
 * 63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角
 * （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角
 * （在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 示例 1：
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 示例 2：
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 */
public class T63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        // 定义 dp 数组并初始化第 1 行和第 1 列。
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }

        // 根据状态转移方程 dp[i][j] = dp[i - 1][j] + dp[i][j - 1] 进行递推。
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
        /*int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[m - 1];*/
        /*int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    f[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (f[i][0] == 2) {
                for (int j = i + 1; j < m; j++) {
                    f[j][0] = 2;
                }
                break;
            }
            f[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            if (f[0][j] == 2) {
                for (int i = j + 1; i < n; j++) {
                    f[0][i] = 2;
                }
                break;
            }
            f[0][j] = 1;
        }
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 2) {
            return 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (f[i - 1][j] == 2) {
                    f[i - 1][j] = 0;
                }
                if (f[i][j - 1] == 2) {
                    f[i][j - 1] = 0;
                }
                if (f[i][j] == 2) {
                    f[i][j] = 0;
                } else {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }
        return f[m - 1][n - 1];*/
    }

    public static void main(String[] args) {
        T63 t63 = new T63();
//        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] obstacleGrid = {{0, 1, 0}, {0, 1, 0}, {0, 0, 0}};
//        int[][] obstacleGrid = {{1,0}};
//        int[][] obstacleGrid = {{0,1},{0,0}};
//        int[][] obstacleGrid = {{0,1},{0,0}};
//        int[][] obstacleGrid = {{0,1}};
        System.out.println(t63.uniquePathsWithObstacles(obstacleGrid));
    }

}
