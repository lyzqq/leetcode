package t409;

/**
 * @author 刘勇志
 * @version 1.0
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * 示例 1:
 * 输入:
 * "abccccdd"
 * 输出:
 * 7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class T409 {
    public int longestPalindrome(String s) {
        int[] num1 = new int[128];
        // int max = 0;
        int ans = 0;
        //boolean bool = false;
        for (int i = 0; i < s.length(); i++) {
            num1[s.charAt(i) - '0']++;
        }
        for (int i = 0; i < num1.length; i++) {
            if (num1[i] % 2 == 0) {
                ans += num1[i];
            } else {
                ans += num1[i] - 1;
                // max = Math.max(max, num1[i]);
                // bool = true;
            }
        }
       /* if (bool) {
            return ans + 1;
        }*/
        return ans == s.length() ? ans : ans + 1;
    }

    public static void main(String[] args) {
//        String s = "abccccdd";
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        T409 t409 = new T409();
        System.out.println(t409.longestPalindrome(s));
    }
}
