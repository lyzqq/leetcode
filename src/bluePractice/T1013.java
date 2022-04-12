package bluePractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Lyz
 * @Date: 2022/4/8 10:48
 * @Version 1.0
 * 1013 数素数 (20 分)
 * 令 P i表示第 i 个素数。现任给两个正整数 M≤N≤10^4，请输出 PM到 P N的所有素数。
 *
 * 输入格式：
 * 输入在一行中给出 M 和 N，其间以空格分隔。
 *
 * 输出格式：
 * 输出从 P M到 P N的所有素数，每 10 个数字占 1 行，其间以空格分隔，但行末不得有多余空格。
 *
 * 输入样例：
 * 5 27
 * 输出样例：
 * 11 13 17 19 23 29 31 37 41 43
 * 47 53 59 61 67 71 73 79 83 89
 * 97 101 103
 */
public class T1013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(), N = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < 105000; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        int count = 0;
        for (int i = M; i < N; i++) {
            count++;
            if (count % 10 != 0) {
                System.out.print(list.get(i - 1) + " ");
            } else {
                System.out.println(list.get(i - 1));
            }
        }
        System.out.println(list.get(N - 1));

    }

    private static boolean isPrime(int i) {
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
