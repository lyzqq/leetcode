package t32;

/**
 * @Author Lyz
 * @Date: 2022/4/10 19:58
 * @Version 1.0
 * <p>
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 * <p>
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 * <p>
 * 输入：s = ""
 * 输出：0
 */
public class T32 {

    public static int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        // dp[i] 严格以i位置结尾，形成的有效括号子串最长长度是什么
        int[] dp = new int[s.length()];
        // 最终的答案
        int max = 0;
        // dp[0] = 0; // 默认
        for (int i = 1; i < s.length(); i++) {
            // if(s.charAt(i) == '(') dp[i] = 0; 以左括号结尾，无效
            if (s.charAt(i) == ')') {
                // 前面已经形成的有效括号长度+2
                int preLen = dp[i - 1];
                // 寻找与当前的右括号相匹配的左括号位置；前面有效括号长度再往前一个位置
                int pre = i - 1 - preLen;

                if (pre >= 0 && s.charAt(pre) == '(') {
                    // 如果寻找到左括号；前面有效括号长度再往前一个位置是左括号
                    // 可以与当前的右括号闭合，有效长度+2
                    dp[i] = dp[i - 1] + 2;

                    // 【注意】此时，需要再往前看下，是否还有有效长度，如果有，合并过来
                    // 例如："()(()())"当前在计算最后一个位置时，dp[7]已经等于dp[6] + 2 = 4 + 2
                    // 但需要再往前看一眼，dp[1] 还有有效长度，合并过来dp[7] = 4 + 2 + 2
                    // 那是否还需要再往前看？
                    // 不需要了，因为，如果前面还有有效长度，其长度肯定已经合并到dp[2]上了
                    // 因此，每次只需要再往前多看一眼就可以
                    if (pre - 1 >= 0) {
                        dp[i] += dp[pre - 1];
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }
}
