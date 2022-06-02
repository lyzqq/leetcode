package t131;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lyz
 * @Date: 2022/4/20 15:41
 * @Version 1.0
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 */
public class T131 {

    public static List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), ans);
        return ans;

    }

    private static void dfs(String s, int start, ArrayList<String> path, List<List<String>> ans) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String s1 = s.substring(start, i + 1);
            if (!isPalindrome(s1)) {
                continue;
            }
            path.add(s1);
            dfs(s, i + 1, path, ans);
            path.remove(path.size() - 1);
        }
    }

    private static boolean isPalindrome(String s1) {
        if (s1 == null || s1.length() <= 1) {
            return true;
        }
        int left = 0, right = s1.length() - 1;
        while (left < right) {
            if (s1.charAt(left) == s1.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }
}
