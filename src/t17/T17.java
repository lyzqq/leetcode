package t17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 */
public class T17 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return null;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        List<String> ans = new ArrayList<>();
        backtrack(ans, phoneMap, digits, 0, new StringBuffer());
        return ans;
    }

    private void backtrack(List<String> ans, Map<Character, String> phoneMap, String digits, int index, StringBuffer an) {
        if (index == digits.length()) {
            ans.add(an.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                an.append(letters.charAt(i));
                backtrack(ans, phoneMap, digits, index + 1, an);
                an.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        T17 t17 = new T17();
        String digits = "23";
        System.out.println(t17.letterCombinations(digits));
    }
}
