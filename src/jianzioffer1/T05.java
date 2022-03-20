package jianzioffer1;

/**
 * @Author Lyz
 * @Date: 2022/3/2 9:49
 * @Version 1.0
 * <p>
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class T05 {
    public String replaceSpace(String s) {
        if (s.length() == 0) return null;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                sb.append(c);
            } else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        T05 t05 = new T05();
        String s = "We are happy.";
        System.out.println(t05.replaceSpace(s));
    }
}
