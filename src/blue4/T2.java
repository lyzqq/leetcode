package blue4;

import java.util.Scanner;

/**
 * @Author Lyz
 * @Date: 2022/3/19 19:28
 * @Version 1.0
 * 求a
 * n
 *  除以m的余数。
 *
 * 输入格式:
 * 分别输入整数a，n，m，其中1<a<100,000，1<m<100,000，1<n<100,000,000。
 *
 * 输出格式:
 * 输出余数。
 *
 * 输入样例:
 * 5 6 7
 * 输出样例:
 * 1
 */
public class T2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int res = a;
        for (int i = 2; i <= n; i++) {
            res = res * a % m;
        }
        System.out.println(res);
    }
}
