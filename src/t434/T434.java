package t434;

/**
 * @author 刘勇志
 * @version 1.0
 * 434. 字符串中的单词数
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 */
public class T434 {
    public int countSegments(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s += ' ';
        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != ' ' && s.charAt(i + 1) == ' ') {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        T434 t434 = new T434();
        String s = "Hello, my name is John";
        System.out.println(t434.countSegments(s));
    }
}
