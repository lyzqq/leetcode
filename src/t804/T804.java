package t804;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author Lyz
 * @Date: 2022/4/10 10:21
 * @Version 1.0
 * 804. 唯一摩尔斯密码词
 * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如:
 * <p>
 * 'a' 对应 ".-" ，
 * 'b' 对应 "-..." ，
 * 'c' 对应 "-.-." ，以此类推。
 * 为了方便，所有 26 个英文字母的摩尔斯密码表如下：
 * <p>
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * 给你一个字符串数组 words ，每个单词可以写成每个字母对应摩尔斯密码的组合。
 * <p>
 * 例如，"cab" 可以写成 "-.-..--..." ，(即 "-.-." + ".-" + "-..." 字符串的结合)。我们将这样一个连接过程称作 单词翻译 。
 * 对 words 中所有单词进行单词翻译，返回不同 单词翻译 的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: words = ["gin", "zen", "gig", "msg"]
 * 输出: 2
 * 解释:
 * 各单词翻译如下:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 * <p>
 * 共有 2 种不同翻译, "--...-." 和 "--...--.".
 * 示例 2：
 * <p>
 * 输入：words = ["a"]
 * 输出：1
 */
public class T804 {

    public static int uniqueMorseRepresentations(String[] words) {

        HashMap<Character, String> map = new HashMap<>();
        String[] password = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(password[word.charAt(i) - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));
    }

}

