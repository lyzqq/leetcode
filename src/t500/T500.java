package t500;

import t5.T5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 刘勇志
 * @version 1.0
 * 500. 键盘行
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 * 美式键盘 中：
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 * 示例 1：
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 * 示例 2：
 * 输入：words = ["omk"]
 * 输出：[]
 * 示例 3：
 * 输入：words = ["adsdf","sfd"]
 * 输出：["adsdf","sfd"]
 */
public class T500 {
    public String[] findWords(String[] words) {
        // rowIdx 对应的是每个字母所在的行号
        List<String> list = new ArrayList<String>();
        String rowIdx = "12210111011122000010020202";
        for (String word : words) {
            boolean isValid = true;
            char idx = rowIdx.charAt(Character.toLowerCase(word.charAt(0)) - 'a');
            for (int i = 1; i < word.length(); ++i) {
                if (rowIdx.charAt(Character.toLowerCase(word.charAt(i)) - 'a') != idx) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                list.add(word);
            }
        }
        return list.toArray(new String[list.size()]);
        /*String s1 = "qwertyuiopQWERTYUIOP";
        String s2 = "asdfghjklASDFGHJKL";
        String s3 = "zxcvbnmZXCVBNM";
        ArrayList<Object> list = new ArrayList<>();
        for (String word : words) {
            int len = word.length();
            int n1 = 0, n2 = 0, n3 = 0;
            for (int i = 0; i < len; i++) {
                if (s1.contains(word.charAt(i) + "")) {
                    n1++;
                    if (n1 != i + 1) {
                        break;
                    }

                } else if (s2.contains(word.charAt(i) + "")) {
                    n2++;
                    if (n2 != i + 1) {
                        break;
                    }
                } else {
                    n3++;
                    if (n3 != i + 1) {
                        break;
                    }
                }
            }
            if (n1 == len || n2 == len || n3 == len) {
                list.add(word);
            }
        }
        return list.toArray(new String[list.size()]);
        */
    }

    public static void main(String[] args) {
        T500 t500 = new T500();
        String[] words = {"Hello","Alaska","Dad","Peace"};
        System.out.println(Arrays.toString(t500.findWords(words)));
    }
}
