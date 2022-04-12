package bluePractice;

import java.util.Scanner;

/**
 * @Author Lyz
 * @Date: 2022/4/8 16:54
 * @Version 1.0
 *
 * 1016 部分A+B (15 分)
 * 正整数 A 的“DA（为 1 位整数）部分”定义为由 A 中所有 DA组成的新整数 PA 。例如：给定 A=3862767，
 * DA=6，则 A 的“6 部分”PA是 66，因为 A 中有 2 个 6。
 *
 * 现给定 A、DA 、B、DB，请编写程序计算 PA+PB。
 *
 * 输入格式：
 * 输入在一行中依次给出 A、DA、B、DB，中间以空格分隔，其中 0<A,B<10^9
 *  。
 *
 * 输出格式：
 * 在一行中输出 PA+PB的值。
 *
 * 输入样例 1：
 * 3862767 6 13530293 3
 * 输出样例 1：
 * 399
 * 输入样例 2：
 * 3862767 1 13530293 8
 * 输出样例 2：
 * 0
 */
public class T1016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(), DA = sc.nextInt();
        int B = sc.nextInt(), DB = sc.nextInt();
        int res1 = 0, res2 = 0;
        while (A != 0) {
            int temp = A % 10;
            if (temp == DA) {
                res1 = res1 * 10 + DA;
            }
            A /= 10;
        }
        while (B != 0) {
            int temp = B % 10;
            if (temp == DB) {
                res2 = res2 * 10 + DB;
            }
            B /= 10;
        }
        sc.close();
        System.out.println(res1 + res2);
    }
}
