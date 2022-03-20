package t748;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 748. 最短补全词
 * 给定一个字符串牌照 licensePlate 和一个字符串数组 words ，请你找出并返回 words 中的 最短补全词 。
 * 如果单词列表（words）中的一个单词包含牌照（licensePlate）中所有的字母，那么我们称之为 补全词 。
 * 在所有完整词中，最短的单词我们称之为 最短补全词 。
 * <p>
 * 单词在匹配牌照中的字母时要：
 * 忽略牌照中的数字和空格。
 * 不区分大小写，比如牌照中的 "P" 依然可以匹配单词中的 "p" 字母。
 * 如果某个字母在牌照中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。
 * 例如：licensePlate = "aBc 12c"，那么它由字母 'a'、'b' （忽略大写）和两个 'c' 。可能的 补全词
 * 是 "abccdef"、"caaacab" 以及 "cbca" 。
 * <p>
 * 题目数据保证一定存在一个最短补全词。当有多个单词都符合最短补全词的匹配条件时取单词列表中最靠前的一个。
 * 示例 1：
 * 输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * 输出："steps"
 * 说明：最短补全词应该包括 "s"、"p"、"s" 以及 "t"。在匹配过程中我们忽略牌照中的大小写。
 * "step" 包含 "t"、"p"，但只包含一个 "s"，所以它不符合条件。
 * "steps" 包含 "t"、"p" 和两个 "s"。
 * "stripe" 缺一个 "s"。
 * "stepple" 缺一个 "s"。
 * 因此，"steps" 是唯一一个包含所有字母的单词，也是本样例的答案。
 * <p>
 * 示例 2：
 * 输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * 输出："pest"
 * 说明：存在 3 个包含字母 "s" 且有着最短长度的补全词，"pest"、"stew"、和 "show" 三者长度相同，但我们返回最先出现的
 * 补全词 "pest"
 * <p>
 * 示例 3：
 * 输入：licensePlate = "Ah71752", words = ["suggest","letter","of","husband","easy","education","drug","prevent","writer","old"]
 * 输出："husband"
 * <p>
 * 示例 4：
 * 输入：licensePlate = "OgEu755", words = ["enough","these","play","wide","wonder","box","arrive","money","tax","thus"]
 * 输出："enough"
 * <p>
 * 示例 5：
 * 输入：licensePlate = "iMSlpe4", words = ["claim","consumer","student","camera","public","never","wonder","simple","thought","use"]
 * 输出："simple"
 */
public class T748 {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] target = count(licensePlate);
        String ans = "";
        for (String word : words) {
            if ((word.length() < ans.length() || ans.length() == 0) &&
                    dominates(count(word.toLowerCase()), target))
                ans = word;
        }
        return ans;
    }

    public boolean dominates(int[] word1, int[] word2) {
        for (int i = 0; i < 26; ++i) {
            if (word1[i] < word2[i]) {
                return false;
            }
        }
        return true;
    }

    public int[] count(String word) {
        int[] res = new int[26];
        for (char c : word.toCharArray()) {
            int index = Character.toLowerCase(c) - 'a';
            if (0 <= index && index <= 26) {
                res[index]++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        T748 t748 = new T748();
        String licensePlate = "1s3 PSt";
        String[] words = {"step", "steps", "stripe", "stepple"};
        System.out.println(t748.shortestCompletingWord(licensePlate, words));
    }
}
