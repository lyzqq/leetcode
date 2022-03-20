package t1189;

import java.nio.charset.StandardCharsets;

/**
 * @Author Lyz
 * @Date: 2022/2/23 20:26
 * @Version 1.0
 * <p>
 * 1189. “气球” 的最大数量
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 * <p>
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "nlaebolko"
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：text = "leetcode"
 * 输出：0
 */
public class T1189 {

    public int maxNumberOfBalloons(String text) {
        int[] cnts = new int[5];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == 'b') cnts[0]++;
            if (c == 'a') cnts[1]++;
            if (c == 'l') cnts[2]++;
            if (c == 'o') cnts[3]++;
            if (c == 'n') cnts[4]++;
        }
        cnts[2] /= 2; cnts[3] /= 2;
        int ans = cnts[0];
        for (int i = 0; i < 5; ++i) ans = Math.min(ans, cnts[i]);
        return ans;
    }

    public static void main(String[] args) {
        T1189 t1189 = new T1189();
        String text = "nlaebolko";
        System.out.println(t1189.maxNumberOfBalloons(text));
    }
}
