package atx1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author Lyz
 * @Date: 2022/4/21 21:39
 * @Version 1.0
 * 小Q想要给他的朋友发送一个神秘字符串，但是他发现字符串的过于长了，于是小Q发明了一种压缩算法对字符串中重复的部分进行了压缩，对于字符串中连续的m个相同字符串S将会压缩为[m|S](m为一个整数且1<=m<=100)，例如字符串ABCABCABC将会被压缩为[3|ABC]，现在小Q的同学收到了小Q发送过来的字符串，你能帮助他进行解压缩么？
 * <p>
 * 输入例子1:
 * "HG[3|B[2|CA]]F"
 * 输出例子1:
 * "HGBCACABCACABCACAF"
 * 例子说明1:
 * HG[3|B[2|CA]]F−>HG[3|BCACA]F−>HGBCACABCACABCACAF
 */
public class T1 {

    public static String compress(String str) {
        if (!str.contains("[") || !str.contains("]")) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        int len = str.length();
        char[] ch = str.toCharArray();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (ch[i] == '[') {
                stack.push(i);
            } else if (ch[i] == ']') {
                int l = stack.pop();
                int r = i;
                String s = str.substring(l + 1, r);
                String res = helper(s);
                sb.delete(l, r + 1);
                sb.insert(l, res);
                break;
            }
        }
        return compress(sb.toString());
    }

    // 拆分括号中的
    private static String helper(String str) {
        StringBuilder sb = new StringBuilder();
        String[] sp = str.split("\\|");
        int num = Integer.parseInt(sp[0]);
        String s = sp[1];
        for (int i = 0; i < num; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(compress(s));
    }
}
