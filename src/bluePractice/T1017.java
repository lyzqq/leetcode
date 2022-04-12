package bluePractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Author Lyz
 * @Date: 2022/4/8 17:01
 * @Version 1.0
 * 1017 A除以B (20 分)
 * 本题要求计算 A/B，其中 A 是不超过 1000 位的正整数，B 是 1 位正整数。你需要输出商数 Q 和余数 R，使得 A=B×Q+R 成立。
 *
 * 输入格式：
 * 输入在一行中依次给出 A 和 B，中间以 1 空格分隔。
 *
 * 输出格式：
 * 在一行中依次输出 Q 和 R，中间以 1 空格分隔。
 *
 * 输入样例：
 * 123456789050987654321 7
 * 输出样例：
 * 17636684150141093474 3
 */
public class T1017 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        bf.close();
        BigInteger A = new BigInteger(s[0]);
        BigInteger B = new BigInteger(s[1]);
        BigInteger[] res = A.divideAndRemainder(B);
        System.out.println(res[0] + " " + res[1]);
        /**
         * 超时
        Scanner sc = new Scanner(System.in);
        BigInteger A = sc.nextBigInteger();
        BigInteger B = sc.nextBigInteger();
        BigInteger[] result = A.divideAndRemainder(B);
        sc.close();
        System.out.print(result[0] + " " + result[1]);
         */
    }
}
