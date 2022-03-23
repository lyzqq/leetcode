package t2038;

/**
 * @Author Lyz
 * @Date: 2022/3/22 11:10
 * @Version 1.0
 * 2038. 如果相邻两个颜色均相同则删除当前颜色
 * 总共有 n 个颜色片段排成一列，每个颜色片段要么是 'A' 要么是 'B' 。给你一个长度为 n 的字符串 colors ，其中 colors[i] 表示第 i 个颜色片段的颜色。
 * <p>
 * Alice 和 Bob 在玩一个游戏，他们 轮流 从这个字符串中删除颜色。Alice 先手 。
 * <p>
 * 如果一个颜色片段为 'A' 且 相邻两个颜色 都是颜色 'A' ，那么 Alice 可以删除该颜色片段。Alice 不可以 删除任何颜色 'B' 片段。
 * 如果一个颜色片段为 'B' 且 相邻两个颜色 都是颜色 'B' ，那么 Bob 可以删除该颜色片段。Bob 不可以 删除任何颜色 'A' 片段。
 * Alice 和 Bob 不能 从字符串两端删除颜色片段。
 * 如果其中一人无法继续操作，则该玩家 输 掉游戏且另一玩家 获胜 。
 * 假设 Alice 和 Bob 都采用最优策略，如果 Alice 获胜，请返回 true，否则 Bob 获胜，返回 false。
 * <p>
 * <p>
 * 示例 1：
 * 输入：colors = "AAABABB"
 * 输出：true
 * 解释：
 * AAABABB -> AABABB
 * Alice 先操作。
 * 她删除从左数第二个 'A' ，这也是唯一一个相邻颜色片段都是 'A' 的 'A' 。
 * 现在轮到 Bob 操作。
 * Bob 无法执行任何操作，因为没有相邻位置都是 'B' 的颜色片段 'B' 。
 * 因此，Alice 获胜，返回 true 。
 * 示例 2：
 * <p>
 * 输入：colors = "AA"
 * 输出：false
 * 解释：
 * Alice 先操作。
 * 只有 2 个 'A' 且它们都在字符串的两端，所以她无法执行任何操作。
 * 因此，Bob 获胜，返回 false 。
 * 示例 3：
 * 输入：colors = "ABBBBBBBAAA"
 * 输出：false
 * 解释：
 * ABBBBBBBAAA -> ABBBBBBBAA
 * Alice 先操作。
 * 她唯一的选择是删除从右数起第二个 'A' 。
 * <p>
 * ABBBBBBBAA -> ABBBBBBAA
 * 接下来轮到 Bob 操作。
 * 他有许多选择，他可以选择任何一个 'B' 删除。
 * <p>
 * 然后轮到 Alice 操作，她无法删除任何片段。
 * 所以 Bob 获胜，返回 false 。
 */
public class T2038 {

    public boolean winnerOfGame(String colors) {
            char[] cs = colors.toCharArray();
            int n = cs.length;
            int countA = 0, countB = 0;
            for (int i = 1; i < n - 1; i++) {
                if (cs[i - 1] == 'A' && cs[i] == 'A' && cs[i + 1] == 'A') countA++;
                if (cs[i - 1] == 'B' && cs[i] == 'B' && cs[i + 1] == 'B') countB++;
            }
            return countA > countB;
    }
//    public boolean winnerOfGame(String colors) {
//        int countA = 0, countB = 0;
//        countA = count(colors, 'A');
//        countB = count(colors, 'B');
//        return countA > countB;
//    }
//
//    private int count(String colors, char a) {
//        int temp = 0, count = 0;
//        for (int i = 0; i < colors.length() - 1; i++) {
//            if (colors.charAt(i) == a) {
//                temp++;
//            } else {
//                if (temp >= 3) {
//                    count += (temp - 2);
//                }
//                temp = 0;
//            }
//        }
//        if (colors.charAt(colors.length() - 1) == a) {
//            temp++;
//        }
//        if (temp >= 3) count += temp - 2;
//        return count;
//    }

    public static void main(String[] args) {
        T2038 t2038 = new T2038();
//        String colors = "ABBBBBBBAAA";
        String colors = "ABBBBBBAA";
        System.out.println(t2038.winnerOfGame(colors));
    }
}
