package t796;

/**
 * @Author Lyz
 * @Date: 2022/4/7 14:35
 * @Version 1.0
 * 给定两个字符串, s和goal。如果在若干次旋转操作之后，s能变成goal，那么返回true。
 * <p>
 * s的 旋转操作 就是将s 最左边的字符移动到最右边。
 * <p>
 * 例如, 若s = 'abcde'，在旋转一次之后结果就是'bcdea'。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcde", goal = "cdeab"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "abcde", goal = "abced"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T796 {
    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        StringBuilder sb = new StringBuilder(s);
        sb.append(s);
        return sb.toString().contains(goal);
    }

    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";
        System.out.println(rotateString(s, goal));
    }
}
