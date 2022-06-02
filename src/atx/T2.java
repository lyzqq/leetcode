package atx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author Lyz
 * @Date: 2022/4/21 20:43
 * @Version 1.0
 * [编程题]第K小子串(客户端开发卷)
 * 时间限制：C/C++ 2秒，其他语言4秒
 * 空间限制：C/C++ 256M，其他语言512M
 * <p>
 * 输入一个字符串 s，s 由小写英文字母组成，保证 s 长度小于等于 5000 并且大于等于 1。
 * 在 s 的所有不同的子串中，输出字典序第 k 小的字符串。
 * 字符串中任意个连续的字符组成的子序列称为该字符串的子串。
 * 字母序表示英文单词在字典中的先后顺序，即先比较第一个字母，若第一个字母相同，
 * 则比较第二个字母的字典序，依次类推，则可比较出该字符串的字典序大小。
 * <p>
 * 数据范围：  ，
 * 进阶：空间复杂度  ， 时间复杂度
 * <p>
 * 输入描述:
 * 第一行输出一个字符串 s，保证 s 长度小于等于 5000 大于等于 1。
 * 第二行一个整数 k (1<= k <= 5)，保证 s 不同子串个数大于等于 k。
 * 输出描述:
 * 输出一个字符串表示答案。
 * 输入例子1:
 * aabb
 * 3
 * 输出例子1:
 * aab
 * 例子说明1:
 * 不同的子串依次为：
 * a aa aab aabb ab abb b bb
 * 所以答案为aab
 * 输入例子2:
 * aaa
 * 3
 * 输出例子2:
 * aaa
 */
public class T2 {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        int k = sc.nextInt();
//        List<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int k = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        PriorityQueue<String> queue = new PriorityQueue<>((s1, s2) -> s2.compareTo(s1));
//        for (int i = 0; i < s.length() - 1; i++) {
//            for (int j = i + 1; j <= s.length(); j++) {
        for (int len = 1; len <= k; len++) {
            for (int i = 0; i < s.length() - len + 1; i++) {
//                set.add(s.substring(i,j));
                String subString = s.substring(i, i + len);
                if (!set.contains(subString)) {
                    if (queue.size() < k) {
                        queue.offer(subString);
                    } else {
                        if (subString.compareTo(queue.peek()) < 0) {
                            queue.poll();
                            queue.offer(subString);
                        }
                    }
                    set.add(subString);
                }
            }
        }
//        String[] words = set.toArray(new String[0]);
        System.out.println(queue.peek());
    }

    /*
    private static String sort(String[] words, int k) {
        String min;
        int count = 0;
        for (int i = 0; i < words.length - 1; i++) {
            min = words[i];
            int tem = 0;
            for (int j = i + 1; j < words.length; j++) {
                if (min.compareTo(words[j]) > 0) {
                    min = words[j];
                    tem = j;
                }
            }
            if (!min.equals(words[i])) {
                String temp = words[i];
                words[i] = min;
                words[tem] = temp;
            }
            count++;
            if (count == k) {
                return words[k - 1];
            }
        }
        return " ";
    }*/
}
