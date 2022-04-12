package jianzioffer1;

/**
 * @Author Lyz
 * @Date: 2022/4/12 16:09
 * @Version 1.0
 */
public class T50 {

    public static char firstUniqChar(String s) {
        int[] tem = new int[26];
        for (int i = 0; i < s.length(); i++) {
            tem[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (tem[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        String s = "abaccdeff";
        System.out.println(firstUniqChar(s));
    }
}
