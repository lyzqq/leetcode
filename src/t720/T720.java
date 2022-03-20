package t720;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Lyz
 * @Date: 2022/3/17 9:41
 * @Version 1.0
 * <p>
 * 720. 词典中最长的单词
 * 给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，该单词是由 words 词典中其他单词逐步添加一个字母组成。
 * <p>
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["w","wo","wor","worl", "world"]
 * 输出："world"
 * 解释： 单词"world"可由"w", "wo", "wor", 和 "worl"逐步添加一个字母组成。
 * 示例 2：
 * <p>
 * 输入：words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出："apple"
 * 解释："apply" 和 "apple" 都能由词典中的单词组成。但是 "apple" 的字典序小于 "apply"
 */
public class T720 {
    public String longestWord(String[] words) {
        String ans = "";
        Set<String> set = new HashSet<>();
        for (String s : words) set.add(s);
        for (String s : set) {
            int n = s.length(), m = ans.length();
            if (n < m) continue;
            if (n == m && s.compareTo(ans) > 0) continue;
            boolean ok = true;
            for (int i = 1; i <= n && ok; i++) {
                String sub = s.substring(0,i);
                if (!set.contains(sub)) ok = false;
            }
            if (ok) ans = s;
        }
        return ans;
//        int res = 0, len0 = 0;
//        for (int i = 0; i < words.length; i++) {
//             int len = words[i].length();
//             if (len > len0) {
//                 len0 = len;
//                 res = i;
//             }
//        }
//        return words[res];
    }

    public static void main(String[] args) {
        T720 t720 = new T720();
//        String[] words = {"w", "wo", "wor", "worl", "world"};
        String[] words = { "a", "banana", "app", "appl", "ap", "apply", "apple"};

        System.out.println(t720.longestWord(words));
    }
}
