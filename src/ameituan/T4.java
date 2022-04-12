package ameituan;

import java.util.Scanner;

/**
 * @Author Lyz
 * @Date: 2022/4/9 16:58
 * @Version 1.0
 */
public class T4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        if (n < 2) {
            System.out.println(0);
            return;
        }
        if (n == 2) {
            System.out.println(2);
            return;
        }
        int[] dp = new int[n + 1];
        dp[2] = 2;
        dp[3] = 6 + 12;
        dp[4] = 12 + 72;
        dp[5] = 20 + 200;

//        for (int i = 3; i <= n; i++) {
        for (int i = 6; i <= n; i++) {
//            dp[i] = (n * (n - 1) * dp[n - 1] + n * (n - 1)) % 1000000007;
            dp[i] = (6 * dp[n - 1] + n * (n - 1)) % 1000000007;
        }
        System.out.println(dp[n]);
    }
}