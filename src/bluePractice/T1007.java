package bluePractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Lyz
 * @Date: 2022/4/7 16:53
 * @Version 1.0
 * 1007 素数对猜想 (20 分)
 * 让我们定义dn 为：dn =pn+1−pn，其中pi是第i个素数。显然有d1=1，且对于n>1有dn是偶数。
 * “素数对猜想”认为“存在无穷多对相邻且差为2的素数”。
 *
 * 现给定任意正整数N(<10^5)，请计算不超过N的满足猜想的素数对的个数。
 *
 * 输入格式:
 * 输入在一行给出正整数N。
 *
 * 输出格式:
 * 在一行中输出不超过N的满足猜想的素数对的个数。
 *
 * 输入样例:
 */
public class T1007 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
//        List<Integer> list = new ArrayList<>();
        int c = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
//                list.add(i);
                array[c++] = i;
            }
        }
//        int[] array = list.stream().mapToInt(Integer::valueOf).toArray();
        int len = array.length, count = 0;
        for (int left = 0; left < len - 1; left++) {
            if (array[left] == 0) break;
            if ((array[left + 1] - array[left]) == 2) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
