package aWeeklyCompetition.first;

import java.util.*;

/**
 * @Author Lyz
 * @Date: 2022/5/28 23:05
 * @Version 1.0
 * <p>
 * 给你一个整数 n ，表示一个国家里的城市数目。城市编号为 0 到 n - 1 。
 * 给你一个二维整数数组 roads ，其中 roads[i] = [ai, bi] 表示城市 ai 和 bi 之间有一条 双向 道路。
 * 你需要给每个城市安排一个从 1 到 n 之间的整数值，且每个值只能被使用 一次 。道路的 重要性 定义为这条道路连接的两座城市数值 之和 。
 * 请你返回在最优安排下，所有道路重要性 之和 最大 为多少。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5, roads = [[0,1],[1,2],[2,3],[0,2],[1,3],[2,4]]
 * 输出：43
 * 解释：上图展示了国家图和每个城市被安排的值 [2,4,5,3,1] 。
 * - 道路 (0,1) 重要性为 2 + 4 = 6 。
 * - 道路 (1,2) 重要性为 4 + 5 = 9 。
 * - 道路 (2,3) 重要性为 5 + 3 = 8 。
 * - 道路 (0,2) 重要性为 2 + 5 = 7 。
 * - 道路 (1,3) 重要性为 4 + 3 = 7 。
 * - 道路 (2,4) 重要性为 5 + 1 = 6 。
 * 所有道路重要性之和为 6 + 9 + 8 + 7 + 7 + 6 = 43 。
 * 可以证明，重要性之和不可能超过 43 。
 * 示例 2：
 * <p>
 * 输入：n = 5, roads = [[0,3],[2,4],[1,3]]
 * 输出：20
 * 解释：上图展示了国家图和每个城市被安排的值 [4,3,2,5,1] 。
 * - 道路 (0,3) 重要性为 4 + 5 = 9 。
 * - 道路 (2,4) 重要性为 2 + 1 = 3 。
 * - 道路 (1,3) 重要性为 3 + 5 = 8 。
 * 所有道路重要性之和为 9 + 3 + 8 = 20 。
 * 可以证明，重要性之和不可能超过 20 。
 * <p>
 * <p>
 * 提示：
 * 2 <= n <= 5 * 104
 * 1 <= roads.length <= 5 * 104
 * roads[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 * 没有重复道路。
 */
public class T6085 {
    public static long maximumImportance(int n, int[][] roads) {
        Map<Integer, Integer> map = new TreeMap<>();
        int len = roads.length;
        long sum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 2; j++) {
                map.put(roads[i][j], map.getOrDefault(roads[i][j], 0) + 1);
            }
        }

        Map<Integer, Integer> map1 = sortMap(map);
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            entry.setValue(n--);
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 2; j++) {
                sum += map1.get(roads[i][j]);
            }
        }
        return sum;
    }

    public static Map<Integer, Integer> sortMap(Map<Integer, Integer> map) {
        //利用Map的entrySet方法，转化为list进行排序
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        //利用Collections的sort方法对list排序
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                //正序排列，倒序反过来
                return o2.getValue() - o1.getValue();
            }
        });
        //遍历排序好的list，一定要放进LinkedHashMap，因为只有LinkedHashMap是根据插入顺序进行存储
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer,Integer> e : entryList) {
            linkedHashMap.put(e.getKey(),e.getValue());
        }
        return linkedHashMap;
    }


    public static void main(String[] args) {
        int n = 5;
        int[][] roads = {{0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}};
        System.out.println(maximumImportance(n, roads));
    }
}
