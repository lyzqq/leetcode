package t709;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 709. 转换成小写字母
 * 给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
 * <p>
 * 示例 1：
 * 输入：s = "Hello"
 * 输出："hello"
 * <p>
 * 示例 2：
 * 输入：s = "here"
 * 输出："here"
 * <p>
 * 示例 3：
 * 输入：s = "LOVELY"
 * 输出："lovely"
 */
public class T709 {

    public String toLowerCase(String s) {
//        return s.toLowerCase();
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] += 32;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        T709 t709 = new T709();
        String s = "Hello";
        System.out.println(t709.toLowerCase(s));
    }
}
