package t447;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘勇志
 * @version 1.0
 * 447. 回旋镖的数量
 * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组
 * ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 * 返回平面上所有回旋镖的数量。
 * 示例 1：
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * 示例 2：
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：2
 * 示例 3：
 * 输入：points = [[1,1]]
 * 输出：0
 */
public class T447 {

    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        if (n == 1) {
            return 0;
        }
        int res = 0;
        for (int[] p : points) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] q : points) {
                int dis = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int m = entry.getValue();
                res += m * (m - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        T447 t447 = new T447();
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println(t447.numberOfBoomerangs(points));
    }
}
