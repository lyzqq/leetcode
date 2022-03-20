package t598;

/**
 * @author 刘勇志
 * @version 1.0
 * 598. 范围求和 II
 * 给定一个初始元素全部为 0，大小为 m*n 的矩阵 M 以及在 M 上的一系列更新操作。
 * <p>
 * 操作用二维数组表示，其中的每个操作用一个含有两个正整数 a 和 b 的数组表示，含义是将所有符合 0 <= i < a 以及 0 <= j < b 的元素 M[i][j] 的值都增加 1。
 * <p>
 * 在执行给定的一系列操作后，你需要返回矩阵中含有最大整数的元素个数。
 * <p>
 * 示例 1:
 * 输入:
 * m = 3, n = 3
 * operations = [[2,2],[3,3]]
 * 输出: 4
 * 解释:
 * 初始状态, M =
 * [[0, 0, 0],
 * [0, 0, 0],
 * [0, 0, 0]]
 * 执行完操作 [2,2] 后, M =
 * [[1, 1, 0],
 * [1, 1, 0],
 * [0, 0, 0]]
 * 执行完操作 [3,3] 后, M =
 * [[2, 2, 1],
 * [2, 2, 1],
 * [1, 1, 1]]
 * <p>
 * M 中最大的整数是 2, 而且 M 中有4个值为2的元素。因此返回 4。
 */
public class T598 {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0 || ops[0].length == 0) {
            return m * n;
        }
        int minI = ops[0][0];
        int minY = ops[0][1];
        for (int i = 1; i < ops.length; i++) {
            if (ops[i][0] < minI) minI = ops[i][0];
            if (ops[i][1] < minY) minY = ops[i][1];
        }
        return minI * minY;
    }

    public static void main(String[] args) {
        T598 t598 = new T598();
        int m = 3, n = 3;
        int[][] ops = {{2, 2}, {3, 3}};
        System.out.println(t598.maxCount(m, n, ops));
    }
}
