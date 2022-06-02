package jianzioffer1;

import java.util.Arrays;

/**
 * @Author Lyz
 * @Date: 2022/4/16 18:02
 * @Version 1.0
 * 剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 */
public class T66 {

    public static int[] constructArr(int[] a) {
        int[] res = new int[a.length];
        for (int i = 0, cur = 1; i < a.length; i++) {
            res[i] = cur; // 先乘左边的数，不包括自己
            cur *= a[i];
        }

        for (int i = a.length - 1, cur = 1; i >= 0; i--) {
            res[i] *= cur; // 再乘右边的数，不包括自己
            cur *= a[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(constructArr(a)));
    }
}
