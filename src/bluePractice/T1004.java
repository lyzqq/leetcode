package bluePractice;

import java.util.Scanner;

/**
 * @Author Lyz
 * @Date: 2022/4/7 16:00
 * @Version 1.0
 * 1004 成绩排名 (20 分)
 * 读入 n（>0）名学生的姓名、学号、成绩，分别输出成绩最高和成绩最低学生的姓名和学号。
 * <p>
 * 输入格式：
 * 每个测试输入包含 1 个测试用例，格式为
 * <p>
 * 第 1 行：正整数 n
 * 第 2 行：第 1 个学生的姓名 学号 成绩
 * 第 3 行：第 2 个学生的姓名 学号 成绩
 * ... ... ...
 * 第 n+1 行：第 n 个学生的姓名 学号 成绩
 * 其中姓名和学号均为不超过 10 个字符的字符串，成绩为 0 到 100 之间的一个整数，这里保证在一组测试用例中没有两个学生的成绩是相同的。
 * <p>
 * 输出格式：
 * 对每个测试用例输出 2 行，第 1 行是成绩最高学生的姓名和学号，第 2 行是成绩最低学生的姓名和学号，字符串间有 1 空格。
 */
public class T1004 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[][] input = new String[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                input[i][j] = sc.next();
            }
            sc.nextLine();
        }
        int min = min(input);
        int max = max(input);
        StringBuilder sb = new StringBuilder();
        sb.append(input[max][0]).append(" ").append(input[max][1]);
        StringBuilder sb1 = new StringBuilder();
        sb1.append(input[min][0]).append(" ").append(input[min][1]);
        System.out.println(sb.toString());
        System.out.println(sb1.toString());
    }

    private static int max(String[][] input) {
        int max = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 0; i < input.length; ++i) {
            int tem = Integer.parseInt(input[i][2]);
            if (max < tem) {
                max = tem;
                res = i;
            }
        }
        return res;
    }

    private static int min(String[][] input) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < input.length; ++i) {
            int tem = Integer.parseInt(input[i][2]);
            if (min > tem) {
                min = tem;
                res = i;
            }
        }
        return res;
    }
}
