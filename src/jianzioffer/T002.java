package jianzioffer;

/**
 * @Author Lyz
 * @Date: 2022/3/1 15:34
 * @Version 1.0
 * 剑指 Offer II 002. 二进制加法
 * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * 输入: a = "11", b = "10"
 * 输出: "101"
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class T002 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int len1 = a.length() - 1, len2 = b.length() - 1, c = 0;
        while (len1 >= 0 || len2 >= 0 || c != 0) {
            int i = len1 >= 0 ? a.charAt(len1--) - '0' : 0;
            int j = len2 >= 0 ? b.charAt(len2--) - '0' : 0;
            c = i + j + c;
            sb.append(c % 2);
            c /= 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        T002 t002 = new T002();
        String a = "111";
        String b = "101";
        System.out.println(t002.addBinary(a, b));
    }
}
