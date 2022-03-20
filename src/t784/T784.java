package t784;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘勇志
 * @version 1.0
 * 784. 字母大小写全排列
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。
 * 返回所有可能得到的字符串集合。
 * 示例：
 * 输入：S = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * 输入：S = "3z4"
 * 输出：["3z4", "3Z4"]
 * 输入：S = "12345"
 * 输出：["12345"]
 */
public class T784 {
    List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        dfs(chs, n, 0);
        return res;
    }

    private void dfs(char[] chs, int n, int begin) {
        res.add(new String(chs));
        for (int i = begin; i < n; i++) {
            if (Character.isLetter(chs[i])) {
                char tmp = chs[i];
                chs[i] = (char) (chs[i] - 'a' >= 0 ? chs[i] - 32 : chs[i] + 32);
                dfs(chs, n, i + 1);
                chs[i] = tmp;
            }
        }
    }
        /*List<String> list = new ArrayList<>();
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            str1.delete(0,str1.length());
            str2.delete(0,str2.length());
            if (Character.isLetter(s.charAt(i))) {
                for (int j = 0; j < i; j++) {
                    str1.append(s.charAt(j));
                }
                for (int j = i + 1; j < s.length(); j++) {
                    str2.append(s.charAt(j));
                }
                list.add(str1.toString() + Character.toLowerCase(s.charAt(i)) + str2.toString());
                list.add(str1.toString() + Character.toUpperCase(s.charAt(i)) + str2.toString());
            }
        }
        return list;*/
//    }

    public static void main(String[] args) {
        T784 t784 = new T784();
//        String s = "3z4";
        String s = "a1b2";
        System.out.println(t784.letterCasePermutation(s));
    }
}
