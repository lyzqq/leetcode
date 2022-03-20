package t56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author 刘勇志
 * @version 1.0
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class T56 {
    public int[][] merge(int[][] intervals) {
        int m = intervals.length;
        if (m == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        int left = intervals[0][0], right = intervals[0][1]; // 令第一个区间为头区间
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > right) { // 如果下一个区间在头区间右侧且无交集
                list.add(new int[]{left, right}); // 将头区间放入list
                left = intervals[i][0]; // 更新头区间为当前区间
                right = intervals[i][1];
            } else { // 如果有交集，更新头区间为原头区间和当前区间两个区间的并集
                left = Math.min(left, intervals[i][0]);
                right = Math.max(right, intervals[i][1]);
            }
            if (i == intervals.length - 1) list.add(new int[]{left, right}); // 如果到了最后一个区间，将最后的头区间值加入
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        T56 t56 = new T56();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(t56.merge(intervals));
    }
}
