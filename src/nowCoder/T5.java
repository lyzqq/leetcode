package nowCoder;

/**
 * @Author Lyz
 * @Date: 2022/4/25 15:47
 * @Version 1.0
 *
 * 替换空格
 * 描述
 * 请实现一个函数，将一个字符串s中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 数据范围:0 \le len(s) \le 1000 \0≤len(s)≤1000 。保证字符串中的字符为大写英文字母、小写英文字母和空格中的一种。
 *
 * 示例1
 * 输入："We Are Happy"
 * 返回值："We%20Are%20Happy"
 * 示例2
 * 输入：" "
 * 返回值："%20"
 */
public class T5 {
    public static String replaceSpace (String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder(0);
        for (char aChar : chars) {
            if (aChar == ' ') {
                sb.append("%20");
            } else {
                sb.append(aChar);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "We Are Happy";
        System.out.println(replaceSpace(s));
    }
}
