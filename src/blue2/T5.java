package blue2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author Lyz
 * @Date: 2022/3/11 20:09
 * @Version 1.0
 *
 * 给定一个非负整数n，寻找比它大的最小回文素数。例如，当n=100时，结果为101。因为101是回文数（正读、反读都一样的数）且是素数。
 *
 * 输入格式:
 * 第一行一个T（1≤T≤100），代表有T组测试数据。对于每组测试，输入一个整数n( 0≤n≤65535） 。
 *
 * 输出格式:
 * 对于每组测试，输出比它大的最小回文素数，每个输出占一行。
 *
 * 输入样例:
 * 2
 * 9
 * 99
 * 输出样例:
 * 11
 * 101
 */
public class T5 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        int n = 10;
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            list.add(T5.primePalindrome(sc.nextInt()));
//        }
//        for (Integer num : list) {
//            System.out.println(num);
//        }
//        return;
        System.out.println(primePalindrome(n));
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int[] number, int len) {
        for (int j = 0; j < len / 2; j++)
            if (number[j] != number[len - j - 1]) return false;
        return true;
    }

    public static int primePalindrome(int number) {
        if (number < 2) return 2;
        number = number % 2 == 0 ? number + 1 : number + 2;
        for (int i = number; ; ) {
            int k = i, len = 0;
            int[] nums = new int[10];
            while (k / 10 != 0) {
                nums[len++] = k % 10;
                k /= 10;
            }
            nums[len++] = k;
            if (len % 2 == 0 && i != 11)
                i = (int) Math.pow(10, len) + 1;
            else {
                if (isPalindrome(nums, len))
                    if (isPrime(i)) return i;
                i += 2;
            }
        }
    }
}
