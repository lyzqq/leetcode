package t345;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 刘勇志
 * @version 1.0
 * 345. 反转字符串中的元音字母
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
 * 输入：s = "hello"
 * 输出："holle"
 * <p>
 * 输入：s = "leetcode"
 * 输出："leotcede"
 */
public class Solution {
    Set<Character> set = new HashSet<Character>() {{
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
        add('A');
        add('E');
        add('I');
        add('O');
        add('U');
    }};

    public String reverseVowels(String s) {
//        Character [] vowel = {'a','e','i','o','u','A','E','I','O','U'};
//        List<Character> set =  Arrays.asList(vowel);
        char[] chars = s.toCharArray();
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (set.contains(chars[start]) && set.contains(chars[end])) {
                char c = chars[start];
                chars[start++] = chars[end];
                chars[end--] = c;
            } else if (set.contains(chars[start])) {
                end--;
            } else if (set.contains(chars[end])) {
                start++;
            } else {
                start++;
                end--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
//        String s = "hello";
//        CharSequence chars = s.toString();
//        boolean contains = s.contains(chars);
//        System.out.println(contains);
//        System.out.println(chars.charAt(1));
        Solution solution = new Solution();
        System.out.println(solution.reverseVowels("hello"));
    }
}


