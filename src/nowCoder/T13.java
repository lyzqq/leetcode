package nowCoder;

/**
 * @Author Lyz
 * @Date: 2022/4/26 19:35
 * @Version 1.0
 * <p>
 * JZ13 机器人的运动范围
 * <p>
 * 描述
 * 地上有一个 rows 行和 cols 列的方格。坐标从 [0,0] 到 [rows-1,cols-1] 。一个机器人从坐标 [0,0] 的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于 threshold 的格子。 例如，当 threshold 为 18 时，机器人能够进入方格   [35,37] ，因为 3+5+3+7 = 18。
 * 但是，它不能进入方格 [35,38] ，因为 3+5+3+8 = 19 。请问该机器人能够达到多少个格子？
 * 进阶：空间复杂度 O(nm) \O(nm)  ，时间复杂度 O(nm) \O(nm)
 * 示例1
 * 输入：1,2,3
 * 返回值：3
 * 示例2
 * 输入：0,1,3
 * 返回值：1
 * 示例3
 * 输入：10,1,100
 * 返回值：29
 * 说明：
 * [0,0],[0,1],[0,2],[0,3],[0,4],[0,5],[0,6],[0,7],[0,8],[0,9],[0,10],[0,11],[0,12],[0,13],[0,14],[0,15],[0,16],[0,17],[0,18],[0,19],[0,20],[0,21],[0,22],[0,23],[0,24],[0,25],[0,26],[0,27],[0,28] 这29种，后面的[0,29],[0,30]以及[0,31]等等是无法到达的
 * 示例4
 * 输入：5,10,10
 * 返回值： 21
 */
public class T13 {

    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int res = 0;

    static int cal(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }

    public static int movingCount(int threshold, int rows, int cols) {
        if (threshold == 0) {
            return 1;
        }
        boolean[][] vis = new boolean[rows][cols];
        dfs(0, 0, rows, cols, threshold, vis);
        return res;
    }

    private static void dfs(int i, int j, int rows, int cols, int threshold, boolean[][] vis) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || vis[i][j]) {
            return;
        }
        if (cal(i) + cal(j) > threshold) {
            return;
        }
        res += 1;
        vis[i][j] = true;
        for (int k = 0; k < 4; k++) {
            dfs(i + dir[k][0], j + dir[k][1], rows, cols, threshold, vis);
        }
    }

    public static void main(String[] args) {
        int threshold = 1, rows = 2, cols = 3;
        System.out.println(movingCount(threshold, rows, cols));
    }
}
