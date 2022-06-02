package t819;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author Lyz
 * @Date: 2022/4/17 11:05
 * @Version 1.0
 * <p>
 * 819. 最常见的单词
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
 * <p>
 * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 * <p>
 * 示例：
 * 输入:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * 输出: "ball"
 * 解释:
 * "hit" 出现了3次，但它是一个禁用的单词。
 * "ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。
 * 注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"），
 * "hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。
 */
public class T819 {

    public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replace('!',' ').replace('?',' ').replace('\'',' ').replace(',',' ').replace(';',' ').replace('.',' ').trim();
        String[] s1 = paragraph.split(" ");
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for (String s : banned) {
            map1.put(s, 1);
        }
        for (String s : s1) {
            if (!map1.containsKey(s) && !s.equals("")) {
                map2.put(s, map2.getOrDefault(s, 0) + 1);
            }
        }
        int max = -1;
        String res = null;
        for (String s : map2.keySet()) {
            if (map2.get(s) >= max) {
                max = map2.get(s);
                res = s;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String paragraph = "Bob. hIt, baLl";
//        String[] banned = {"hit", "the"};
        String[] banned = {"hit", "bob"};
        System.out.println(mostCommonWord(paragraph, banned));
    }
}
