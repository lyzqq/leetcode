package blue;

import java.util.*;

/**
 * @Author Lyz
 * @Date: 2022/3/11 11:29
 * @Version 1.0
 */
public class t12_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //int[] nums = new int[n];
        Set<Integer> set = new HashSet<>();
        List<Integer> list;
        set.add(sc.nextInt());
        int a;
        while (n > 1) {
            a = sc.nextInt();
            list = new ArrayList<>(set);
            for (Integer num : list) {
                if (num != a) set.add(Math.abs(num - a));
                set.add(num + a);
            }
            set.add(a);
            n--;
        }
        System.out.println(set.size());
    }
}
