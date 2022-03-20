package replaceSpace;

/**
 * @author 刘勇志
 * @version 1.0
 * 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class Solution {
    public static String replaceSpace(String s) {
//        String s1 = "";
//        for(int i = 0; i < s.length(); i++) {
//           // s.replace(' ', "%20");
//            char c = s.charAt(i);
//
//            if(c == ' ') {
//                s1 += "%20";
//            } else {
//                s1 += c;
//            }
//        }
//    //   System.out.println(s);
//        return s1;
        StringBuilder res = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
        // return s.replace(" ","%20");
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
}
