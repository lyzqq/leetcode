package t1446;

/**
 * @author 刘勇志
 * @version 1.0
 * 1446. 连续字符
 * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 * 请你返回字符串的能量。
 *
 * 示例 1：
 * 输入：s = "leetcode"
 * 输出：2
 * 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
 * 示例 2：
 * 输入：s = "abbcccddddeeeeedcba"
 * 输出：5
 * 解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
 */
public class T1446 {
    public int maxPower(String s) {
        int res = 0, n = s.length(), left = 0, right = 0;
        while (left < n) {
            while (right < n && s.charAt(left) == s.charAt(right)) {
                right++;
            }
            res = Math.max(res, right - left);
            left = right;
        }
        return res;
    }


    public static void main(String[] args) {
        T1446 t1446 = new T1446();
        String s = "abbcccddddeeeeedcba";
        System.out.println(t1446.maxPower(s));
    }
}
