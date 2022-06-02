package t130;

import java.util.Arrays;

/**
 * @Author Lyz
 * @Date: 2022/4/21 19:56
 * @Version 1.0
 * <p>
 * 130. 被围绕的区域
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 示例 2：
 * <p>
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 */
public class T130 {

    static int cors;
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int rows = board.length;
        cors = board[0].length;

        // 用一个虚拟节点，边界上的O的父节点都是这个虚拟节点
        UnionFind uf = new UnionFind(rows * cors + 1);
        int dummyNode = rows * cors;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cors; j++) {
                if (i == 0 || i == rows - 1 || j == 0 || j == cors - 1) {
                    // 边界上的O，把它和dummyNode合并成一个连通区域
                    uf.union(node(i, j), dummyNode);
                } else {
                    // 把上下左右合并成一个连通区域
                    if (i > 0 && board[i - 1][j] == 'O') {
                        uf.union(node(i, j), node(i - 1, j));
                    }
                    if (i < rows - 1 && board[i + 1][j] == 'O') {
                        uf.union(node(i, j), node(i + 1, j));
                    }
                    if (j > 0 && board[i][j - 1] == 'O') {
                        uf.union(node(i, j), node(i, j - 1));
                    }
                    if (j < cors - 1 && board[i][j + 1] == 'O') {
                        uf.union(node(i, j), node(i, j + 1));
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cors; j++) {
                if (uf.isConnected(node(i, j), dummyNode)) {
                    // 和dummyNode在一个连通区域的，那么就是O；
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
        System.out.println(Arrays.deepToString(board));
    }

    int node(int i, int j) {
        return i * cors + j;
    }


    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        new T130().solve(board);
    }
}
