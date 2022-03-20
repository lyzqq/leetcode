package t58;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。
 * 返回字符串中最后一个单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * 示例 1：
 * 输入：s = "Hello World"
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * <p>
 * 示例 3：
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 */
public class T58 {

    public int lengthOfLastWord(String s) {
        int n = s.length();
        int right = n - 1;
        while (s.charAt(right) == ' ') {
            right--;
        }
//        for (int i = 0; i <= right; i++) {
//            num++;
//            if(s.charAt(i) == ' ') {
//                num = 0;
//            }
//        }
        int left = right;
        while (left >= 0 && s.charAt(left) != ' ') {
            left--;
        }
        return right - left;
    }

    public static void main(String[] args) {
        T58 t58 = new T58();
//        String s = "luffy is still joyboy";
        String s = "    fly me   to   the moon  ";
//        String s = "Hello World";
        System.out.println(t58.lengthOfLastWord(s));
    }
}
