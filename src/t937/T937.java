package t937;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author Lyz
 * @Date: 2022/5/3 16:38
 * @Version 1.0
 * 937. 重新排列日志文件
 * 给你一个日志数组 logs。每条日志都是以空格分隔的字串，其第一个字为字母与数字混合的 标识符 。
 * 有两种不同类型的日志：
 * 字母日志：除标识符之外，所有字均由小写字母组成
 * 数字日志：除标识符之外，所有字均由数字组成
 * 请按下述规则将日志重新排序：
 * 所有 字母日志 都排在 数字日志 之前。
 * 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。
 * 数字日志 应该保留原来的相对顺序。
 * 返回日志的最终顺序。
 * <p>
 * 示例 1：
 * 输入：logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * 输出：["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 * 解释：
 * 字母日志的内容都不同，所以顺序为 "art can", "art zero", "own kit dig" 。
 * 数字日志保留原来的相对顺序 "dig1 8 1 5 1", "dig2 3 6" 。
 * 示例 2：
 * 输入：logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * 输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 */
public class T937 {

    static class Log {
        int type, idx;
        String ori, sign, content;

        Log(String s, int _idx) {
            idx = _idx;
            int n = s.length(), i = 0;
            while (i < n && s.charAt(i) != ' ') {
                i++;
            }
            sign = s.substring(0, i);
            content = s.substring(i + 1);
            ori = s;
            type = Character.isDigit(content.charAt(0)) ? 1 : 0;
        }
    }

    public static String[] reorderLogFiles(String[] logs) {
        int n = logs.length;
        List<Log> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Log(logs[i], i));
        }
        Collections.sort(list, (a, b) -> {
            if (a.type != b.type) return a.type - b.type;
            if (a.type == 1) return a.idx - b.idx;
            return !a.content.equals(b.content) ? a.content.compareTo(b.content) : a.sign.compareTo(b.sign);
        });
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = list.get(i).ori;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        System.out.println(Arrays.toString(reorderLogFiles(logs)));
    }
}
