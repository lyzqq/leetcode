package aWeeklyCompetition.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Lyz
 * @Date: 2022/5/28 22:48
 * @Version 1.0
 * 6084. 最多单词数的发件人 显示英文描述
 * 通过的用户数1210
 * 尝试过的用户数1413
 * 用户总通过次数1212
 * 用户总提交次数1731
 * 题目难度Medium
 * 给你一个聊天记录，共包含 n 条信息。给你两个字符串数组 messages 和 senders ，其中 messages[i] 是 senders[i] 发出的一条 信息 。
 * 一条 信息 是若干用单个空格连接的 单词 ，信息开头和结尾不会有多余空格。发件人的 单词计数 是这个发件人总共发出的 单词数 。注意，一个发件人可能会发出多于一条信息。
 * 请你返回发出单词数 最多 的发件人名字。如果有多个发件人发出最多单词数，请你返回 字典序 最大的名字。
 * 注意：
 * 字典序里，大写字母小于小写字母。
 * "Alice" 和 "alice" 是不同的名字。
 * 示例 1：
 * 输入：messages = ["Hello userTwooo","Hi userThree","Wonderful day Alice","Nice day userThree"], senders = ["Alice","userTwo","userThree","Alice"]
 * 输出："Alice"
 * 解释：Alice 总共发出了 2 + 3 = 5 个单词。
 * userTwo 发出了 2 个单词。
 * userThree 发出了 3 个单词。
 * 由于 Alice 发出单词数最多，所以我们返回 "Alice" 。
 * 示例 2：
 * 输入：messages = ["How is leetcode for everyone","Leetcode is useful for practice"], senders = ["Bob","Charlie"]
 * 输出："Charlie"
 * 解释：Bob 总共发出了 5 个单词。
 * Charlie 总共发出了 5 个单词。
 * 由于最多单词数打平，返回字典序最大的名字，也就是 Charlie 。
 *
 * 提示：
 * n == messages.length == senders.length
 * 1 <= n <= 104
 * 1 <= messages[i].length <= 100
 * 1 <= senders[i].length <= 10
 * messages[i] 包含大写字母、小写字母和 ' ' 。
 * messages[i] 中所有单词都由 单个空格 隔开。
 * messages[i] 不包含前导和后缀空格。
 * senders[i] 只包含大写英文字母和小写英文字母。
 */
public class T6084 {
    public static String largestWordCount(String[] messages, String[] senders) {
        int len = messages.length;
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            map.put(senders[i], map.getOrDefault(senders[i], 0) + messages[i].split(" ").length);
        }
        int max = Integer.MIN_VALUE;
        for (Integer value : map.values()) {
            if (value > max) {
                max = value;
            }
        }
        for (String s : map.keySet()) {
            if (map.get(s) == max) {
                list.add(s);
            }
        }
        if (list.size() == 1) {
            return list.get(0);
        } else {
            String[] strings = list.toArray(new String[0]);
            sort(strings);
            return strings[strings.length - 1];
        }
    }

    private static void sort(String[] s1) {
        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s1.length - 1 -i; j++) {
                if (s1[j].compareTo(s1[j + 1]) > 0) {
                    String temp = s1[j];
                    s1[j] = s1[j + 1];
                    s1[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
//        String[] messages = {"Hello userTwooo","Hi userThree","Wonderful day Alice","Nice day userThree"};
//        String[] messages = {"How is leetcode for everyone","Leetcode is useful for practice"};
//        String[] senders = {"Alice","userTwo","userThree","Alice"};
//        String[] senders = {"Bob","Charlie"};

        String[] messages = {"tP x M VC h lmD","D X XF w V","sh m Pgl","pN pa","C SL m G Pn v","K z UL B W ee","Yf yo n V U Za f np","j J sk f qr e v t","L Q cJ c J Z jp E","Be a aO","nI c Gb k Y C QS N","Yi Bts","gp No g s VR","py A S sNf","ZS H Bi De dj dsh","ep MA KI Q Ou"};
        String[] senders = {"OXlq","IFGaW","XQPeWJRszU","Gb","HArIr","Gb","FnZd","FnZd","HArIr","OXlq","IFGaW","XQPeWJRszU","EMoUs","Gb","EMoUs","EMoUs"};
        System.out.println(largestWordCount(messages, senders));
    }
}
