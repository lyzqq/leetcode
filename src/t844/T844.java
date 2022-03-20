package t844;

/**
 * @author 刘勇志
 * @version 1.0
 * 844. 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * 示例 1：
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 */
public class T844 {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
        /*int m = s.length();
        int n = t.length();
        StringBuilder s1 = new StringBuilder(s);
        StringBuilder t1 = new StringBuilder(t);
        if (s.charAt(0) == '#') {
            s1.charAt(0) = '';
        }
        if (t.charAt(0) == '#') {
            t1.deleteCharAt(0);
        }
        for (int i = 1; i < m - 1; i++) {
            if (s.charAt(i) == '#') {
                s1.deleteCharAt(i - 1);
                s1.deleteCharAt(i);
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (t.charAt(i) == '#') {
                t1.deleteCharAt(i - 1);
                t1.deleteCharAt(i);
            }
        }
        return s1 == t1;*/
    }

    public static void main(String[] args) {
        T844 t844 = new T844();
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(t844.backspaceCompare(s, t));
    }
}
