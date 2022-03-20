package t524;

import java.util.Arrays;
import java.util.List;

/**
 * @author 刘勇志
 * @version 1.0
 * 524. 通过删除字母匹配到字典里最长单词
 * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，
 * 该字符串可以通过删除 s 中的某些字符得到。
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 * 示例 1：
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * 示例 2：
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 */
public class T524 {
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String t : dictionary) {
            int i = 0, j = 0;
            if (t.length() > res.length() || (t.length() == res.length() && t.compareTo(res) < 0)) {
                // 对 dictionary中字符串进行匹配
                while (i < t.length() && j < s.length()) {
                    if (t.charAt(i) == s.charAt(j)) {
                        ++i;
                    }
                    ++j;
                }
                // 判断，对res进行更新
                if (i == t.length()) {
                    res = t;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        T524 t524 = new T524();
        String s = "abpcplea";
        List<String> dictionary = Arrays.asList("ale", "apple", "monkey", "plea");
        System.out.println(t524.findLongestWord(s, dictionary));
    }
}
