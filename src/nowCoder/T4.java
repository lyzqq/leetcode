package nowCoder;

/**
 * @Author Lyz
 * @Date: 2022/4/25 15:29
 * @Version 1.0
 * <p>
 * JZ4 二维数组中的查找
 * 描述
 * 在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * [
 * [1,2,8,9],
 * [2,4,9,12],
 * [4,7,10,13],
 * [6,8,11,15]
 * ]
 * 给定 target = 7，返回 true。
 * 给定 target = 3，返回 false。
 * 数据范围：矩阵的长宽满足 0 \le n,m \le 5000≤n,m≤500 ， 矩阵中的值满足 0 \le val \le 10^90≤val≤10
 * 9
 * 进阶：空间复杂度 O(1)O(1) ，时间复杂度 O(n+m)O(n+m)
 * 示例1
 * 输入：7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 * 返回值：true
 * 说明：
 * 存在7，返回true
 * 示例2
 * 输入：1,[[2]]
 * 返回值：false
 * 示例3
 * 输入：
 * 3,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 * 返回值：false
 * 说明：不存在3，返回false
 */
public class T4 {
    public static boolean Find(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        int m = array.length, n = array[0].length;
        int r = 0, c = n - 1;
        while (r < m && c >= 0) {
            if (array[r][c] == target) {
                return true;
            } else if (array[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int target = 7;
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 14}, {6, 8, 11, 15}};
        System.out.println(Find(target, array));
    }
}
