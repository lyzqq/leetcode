package blue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Lyz
 * @Date: 2022/3/10 17:47
 * @Version 1.0
 */
public class t12_1 {
    // static int N = 1000;
    public static void main(String[] args) {
        int i, j;
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long[] a = new long[44725];
        a[0] = a[1] = 1L;
        long cnt;
        if (n == 1) {
            System.out.println(1);
            return;
        } else {
            cnt = 3L;
            for(i = 3; i < 44725; i++) {
                for (j = i - 1; j >= 1; j--) {
                    a[j] += a[j-1];
                    if (a[j] == n) {
                        System.out.println(cnt + i - j);
                        return;
                    }
                }
                cnt += i;
            }
        }
        System.out.println((n + 1) * n / 2 + 2);
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        List<List<Integer>> lists = new ArrayList<>();
//        for(int i = 0; i < n; i++) {
//            List<Integer> list = new ArrayList<>();
//            for(int j = 0; j <= i; j++) {
//                if(j == 0 || j == i) {
//                    list.add(1);
//                } else {
//                    list.add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
//                }
//            }
//            lists.add(list);
//        }
//        int res = 0;
//        loop1:for(int i = 0; i < n; i++) {
//            for(int j = 0; j <= i; j++) {
//                res++;
//                if(n == lists.get(i).get(j)) {
//                    System.out.println(res);
//                    break loop1;
//                }
//            }
//        }
    }
}
