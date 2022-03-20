package jianzioffer;

import java.util.HashMap;

/**
 * @Author Lyz
 * @Date: 2022/3/1 16:55
 * @Version 1.0
 * 剑指 Offer II 005. 单词长度的最大乘积
 * 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
 * <p>
 * 示例 1:
 * 输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "fxyz"。它们不包含相同字符，且长度的乘积最大。
 * 示例 2:
 * <p>
 * 输入: words = ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * 示例 3:
 * <p>
 * 输入: words = ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 */
public class T005 {
    public int maxProduct(String[] words) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            int tem = 0;
//            for (int j = 0; j < words[i].length(); j++) {
//                tem |= (1 << (words[i].charAt(j) - 'a'));
//            }
            for (char c : words[i].toCharArray()) {
                tem |= (1 << c - 'a');
            }
            if (words[i].length() > map.getOrDefault(tem, 0)) {
                map.put(tem, words[i].length());
            }
        }
        int res = 0;
        for (Integer a : map.keySet()) {
            for (Integer b : map.keySet()) {
                if ((a & b) == 0) res = Math.max(res, map.get(a) * map.get(b));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        T005 t005 = new T005();
        String[] words = {"abcw", "baz", "foo", "bar", "fxyz", "abcdef"};
        System.out.println(t005.maxProduct(words));
    }
}
