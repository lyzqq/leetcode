package bluePractice;

import java.util.Scanner;

/**
 * @Author Lyz
 * @Date: 2022/4/7 16:47
 * @Version 1.0
 *
 * 1006 换个格式输出整数 (15 分)
 * 让我们用字母 B 来表示“百”、字母 S 表示“十”，用 12...n 来表示不为零的个位数字 n（<10），换个格式来输出任一个不超过 3 位的正整数。例如 234 应该被输出为 BBSSS1234，因为它有 2 个“百”、3 个“十”、以及个位的 4。
 *
 * 输入格式：
 * 每个测试输入包含 1 个测试用例，给出正整数 n（<1000）。
 *
 * 输出格式：
 * 每个测试用例的输出占一行，用规定的格式输出 n。
 *
 * 输入样例 1：
 * 234
 * 输出样例 1：
 * BBSSS1234
 * 输入样例 2：
 * 23
 * 输出样例 2：
 * SS123
 */
public class T1006 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int bai = n / 100;
        int shi = n / 10 % 10;
        int ge = n % 10;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bai; i++) {
            sb.append("B");
        }
        for (int i = 0; i < shi; i++) {
            sb.append("S");
        }
        for(int i = 0; i < ge; i++) {
            sb.append(i + 1);
        }
        System.out.println(sb.toString());
    }
}
