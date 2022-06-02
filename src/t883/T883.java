package t883;

/**
 * @Author Lyz
 * @Date: 2022/4/26 19:00
 * @Version 1.0
 * 883. 三维形体投影面积
 * 在 n x n 的网格 grid 中，我们放置了一些与 x，y，z 三轴对齐的 1 x 1 x 1 立方体。
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
 * 现在，我们查看这些立方体在 xy 、yz 和 zx 平面上的投影。
 * 投影 就像影子，将 三维 形体映射到一个 二维 平面上。从顶部、前面和侧面看立方体时，我们会看到“影子”。
 * 返回 所有三个投影的总面积 。
 * <p>
 * 示例 1：
 * 输入：[[1,2],[3,4]]
 * 输出：17
 * 解释：这里有该形体在三个轴对齐平面上的三个投影(“阴影部分”)。
 * 示例 2:
 * <p>
 * 输入：grid = [[2]]
 * 输出：5
 * 示例 3：
 * <p>
 * 输入：[[1,0],[0,2]]
 * 输出：8
 */
public class T883 {

    public static int projectionArea(int[][] grid) {
        int n = grid.length;
        int xyA = 0, zxA = 0, yzA = 0;
        for (int i = 0; i < n; i++) {
            int yzH = 0, zxH = 0;
            for (int j = 0; j < n; j++) {
                xyA += grid[i][j] > 0 ? 1 : 0;
                yzH = Math.max(yzH, grid[j][i]);
                zxH = Math.max(zxH, grid[i][j]);
            }
            yzA += yzH;
            zxA += zxH;
        }
        return xyA + yzA + zxA;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2}, {3, 4}};
        System.out.println(projectionArea(grid));
    }
}
