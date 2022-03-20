package blue4;

import java.util.Scanner;

/**
 * @Author Lyz
 * @Date: 2022/3/19 19:49
 * @Version 1.0
 *
 * 回文串，是一种特殊的字符串，它从左往右读和从右往左读是一样的。小龙龙认为回文串才是完美的。现在给你一个串，它不一定是回文的，请你计算最少的交换次数使得该串变成一个完美的回文串。
 *
 * 交换的定义是：交换两个相邻的字符
 *
 * 例如mamad
 *
 * 第一次交换 ad : mamda
 *
 * 第二次交换 md : madma
 *
 * 第三次交换 ma : madam (回文！完美！)
 *
 * 输入格式:
 * 第一行是一个整数N，表示接下来的字符串的长度(N <= 8000)
 *
 * 第二行是一个字符串，长度为N.只包含小写字母
 *
 * 输出格式:
 * 如果可能，输出最少的交换次数。
 *
 * 否则输出Impossible
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * 5
 * mamad
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * 3
 */
public class T4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String s = sc.next();
        if (N == 1 || N == 2) {
            System.out.println(0);
            return;
        }
        char[] a = s.toCharArray();
        int[] countChar = new int[26];
        for (char c : a) {
            countChar[c - 'a']++;
        }
        int cCount = 0;
        for (int i = 0; i < 26; i++) {
            if (countChar[i] % 2 == 1) {
                cCount++;
            }
        }
        if (cCount > 1) {
            System.out.println("Impossible");
            return;
        }
        int count = 0, j = N - 1;
        for (int i = 0; i < j; i++) {
            for (int k = j; k >= i; k--) {
                if (i == k) {
//                    for (int m = i; m < N / 2; m++) {
//                        char t = a[m + 1];
//                        a[m + 1] = a[m];
//                        a[m] = t;
//                    }
                    count += (N / 2) - i;
//                    i--;
                    break;
                } else if (a[i] == a[k]) {
                    // 找到相等的字符就交换 -- 交换到前面那个字符对应的后边的位置
                    for (int m = k; m < j; m++) {
                        char t = a[m];
                        a[m] = a[m + 1];
                        a[m + 1] = t;
                        count++;
                    }
//                    char t = a[N - i];
//                    a[N - i] = a[k];
//                    a[i] = t;
                    j--; // 字符位置成功对应，j--
                    break; // 完成一次交换，跳出循环
                }
            }
        }
        System.out.println(count);
    }
}
