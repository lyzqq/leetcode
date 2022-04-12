package bluePractice;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author Lyz
 * @Date: 2022/4/8 11:25
 * @Version 1.0
 * 1014 福尔摩斯的约会 (20 分)
 * 大侦探福尔摩斯接到一张奇怪的字条：
 * <p>
 * 我们约会吧！
 * 3485djDkxh4hhGE
 * 2984akDfkkkkggEdsb
 * s&hgsfdk
 * d&Hyscvnm
 * 大侦探很快就明白了，字条上奇怪的乱码实际上就是约会的时间星期四 14:04，
 * 因为前面两字符串中第 1 对相同的大写英文字母（大小写有区分）是第 4 个字母 D，
 * 代表星期四；第 2 对相同的字符是 E ，那是第 5 个英文字母，
 * 代表一天里的第 14 个钟头（于是一天的 0 点到 23 点由数字 0 到 9、
 * 以及大写字母 A 到 N 表示）；后面两字符串第 1 对相同的英文字母 s 出现在第 4 个位置（从 0 开始计数）上，
 * 代表第 4 分钟。现给定两对字符串，请帮助福尔摩斯解码得到约会的时间。
 * <p>
 * 输入格式：
 * 输入在 4 行中分别给出 4 个非空、不包含空格、且长度不超过 60 的字符串。
 * <p>
 * 输出格式：
 * 在一行中输出约会的时间，格式为 DAY HH:MM，其中 DAY 是某星期的 3 字符缩写，
 * 即 MON 表示星期一，TUE 表示星期二，WED 表示星期三，THU 表示星期四，
 * FRI 表示星期五，SAT 表示星期六，SUN 表示星期日。题目输入保证每个测试存在唯一解。
 * <p>
 * 输入样例：
 * 3485djDkxh4hhGE
 * 2984akDfkkkkggEdsb
 * s&hgsfdk
 * d&Hyscvnm
 * 输出样例：
 * THU 14:04
 */
public class T1014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ss = new String[4];
        for (int i = 0; i < ss.length; i++) {
            ss[i] = sc.nextLine();
        }
        StringBuilder sb = new StringBuilder();
        Map<Character, String> map = new HashMap<>();
        map.put('A', "MON");
        map.put('B', "TUE");
        map.put('C', "WED");
        map.put('D', "THU");
        map.put('E', "FRI");
        map.put('F', "SAT");
        map.put('G', "SUN");
        boolean flag1 = false;
        boolean flag2 = false;
        for (int i = 0; i < Math.min(ss[0].length(), ss[1].length()); i++) {
            if (ss[0].charAt(i) == ss[1].charAt(i)) {
                // 找周几
                if (!flag1 && ss[0].charAt(i) >= 'A' && ss[0].charAt(i) <= 'G') {
                    sb.append(map.get(ss[0].charAt(i))).append(" ");
                    flag1 = true;
                    continue;
                }
                // 找小时
                if (flag1 && !flag2) {
                    if (ss[0].charAt(i) >= 'A' && ss[0].charAt(i) <= 'N') {
                        sb.append(ss[0].charAt(i) - 'A' + 10).append(":");
                        flag2 = true;
                    } else if (ss[0].charAt(i) >= '0' && ss[0].charAt(i) <= '9') {
                        sb.append(0).append(i).append(":");
                        flag2 = true;
                    }
                }
            }
        }
        // 找分钟
        for (int i = 0; i < Math.min(ss[2].length(), ss[3].length()); i++) {
            if (((ss[2].charAt(i) >= 'A' && ss[2].charAt(i) <= 'Z')
                    || (ss[2].charAt(i) >= 'a' && ss[2].charAt(i) <= 'z')) && ss[2].charAt(i) == ss[3].charAt(i)) {
                if (i < 10) {
                    sb.append(0).append(i);
                } else {
                    sb.append(i);
                }
                break;
            }
        }
        System.out.println(sb);
    }
}
