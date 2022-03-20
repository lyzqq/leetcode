package t557;

import java.util.Arrays;

/**
 * @author 刘勇志
 * @version 1.0
 */
public class T557 {
    public String reverseWords(String s) {
        int n = s.length();
        char[] ch = new char[n];
        int left = 0, tol = 0;
        for (int i = 0; i < s.length(); i++) {
            ch[i] = s.charAt(i);
            tol++;
            if (s.charAt(i) == ' ') {
                reverse(ch, left, tol - 2);
                left = i + 1;
            }
        }
        reverse(ch, left, tol - 1);
        return new String(ch);
    }

    public char[] reverse(char[] str, int left, int right) {
        while (left < right) {
            char c = str[left];
            str[left] = str[right];
            str[right] = c;
            left++;
            right--;
        }
        return str;
        //return str.toString();
    }

    /*可行，就是太慢
    String res = "";
    String tem = "";
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == ' ') {
            res += reverse(tem.toCharArray());
            res += ' ';
            tem = "";
        } else {
            tem += s.charAt(i);
        }
    }
    res += reverse(tem.toCharArray());
    return res;
}
    public String reverse(char[] str) {
        int left = 0, right = str.length - 1;
        while (left < right) {
            char c = str[left];
            str[left] = str[right];
            str[right] = c;
            left++;
            right--;
        }
        return String.valueOf(str);
    }
*/


    public static void main(String[] args) {
        T557 t557 = new T557();
        String s = "Let's take LeetCode contest";
        System.out.println(t557.reverseWords(s));
    }
}
