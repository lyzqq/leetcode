package t9;

/**
 * @author 刘勇志
 * @version 1.0
 * 9. 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * 示例 1：
 * 输入：x = 121
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数
 * <p>
 * 示例 3：
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Solution {
    public Boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int res = 0;
        if (res < x) {
            res = x % 10 + res * 10;
            x /= 10;
        }
        return x == res || res == x / 10;
//            if(x < 0) return false;
//            String s = Integer.toString(x);
//            char[] chars = s.toCharArray();
//            int start = 0, end = s.length() - 1;
//            while (start < end) {
//                if(chars[start] == chars[end]) {
//                    start++;
//                    end--;
//                } else {
//                    return false;
//                }
//            }
//            return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(101));
    }
}
