package t824;

/**
 * @Author Lyz
 * @Date: 2022/4/21 7:58
 * @Version 1.0
 * 824. 山羊拉丁文
 * 给你一个由若干单词组成的句子 sentence ，单词间由空格分隔。每个单词仅由大写和小写英文字母组成。
 * <p>
 * 请你将句子转换为 “山羊拉丁文（Goat Latin）”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。山羊拉丁文的规则如下：
 * <p>
 * 如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"。
 * 例如，单词 "apple" 变为 "applema" 。
 * 如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词 "goat" 变为 "oatgma" 。
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始。
 * 例如，在第一个单词后添加 "a" ，在第二个单词后添加 "aa" ，以此类推。
 * 返回将 sentence 转换为山羊拉丁文后的句子。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：sentence = "I speak Goat Latin"
 * 输出："Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * 示例 2：
 * <p>
 * 输入：sentence = "The quick brown fox jumped over the lazy dog"
 * 输出："heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 */
public class T824 {

    public static String toGoatLatin(String sentence) {
        String trim = sentence.trim();
        String[] words = trim.split(" ");
        StringBuilder ans = new StringBuilder();
        int k = 0;
        for (String word : words) {
            k++;
            StringBuilder temp = new StringBuilder();
            char c = word.charAt(0);
            for (int i = 0; i < k; i++) {
                temp.append('a');
            }
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                ans.append(word).append("ma").append(temp).append(' ');
            } else {
                ans.append(word.substring(1)).append(word.charAt(0)).append("ma").append(temp).append(' ');
            }
        }
        return ans.toString().trim();
    }

    public static void main(String[] args) {
        String sentence = "The quick brown fox jumped over the lazy dog";
        System.out.println(toGoatLatin(sentence));
    }
}
