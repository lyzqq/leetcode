package t3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 */
public class T3 {
    public int lengthOfLongestSubstring(String s) {
        /*int n = s.length(), res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char zf = s.charAt(end);
            if (map.containsKey(zf)) {
                // 遇到相同字符，获取该字符的value值，并更新start。
                start = Math.max(map.get(zf), start);
            }
            // 每遍历一次就更新一次res
            res = Math.max(res, end - start + 1);
            // 放入相同字符的新的value值
            map.put(s.charAt(end), end + 1);
        }
        return res;*/
        HashSet<Character> set = new HashSet<>();
        int left = -1, right = s.length(), res = 0;
        for (int i = 0; i < right; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (left + 1 < right && !set.contains(s.charAt(left + 1))) {
                set.add(s.charAt(left + 1));
                ++left;
            }
            res = Math.max(res, left - i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcbacbb";
        T3 t3 = new T3();
        System.out.println(t3.lengthOfLongestSubstring(s));
    }
}
