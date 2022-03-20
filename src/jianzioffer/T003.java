package jianzioffer;

import java.util.Arrays;

/**
 * @Author Lyz
 * @Date: 2022/3/1 15:50
 * @Version 1.0
 * 剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
 * 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 2
 * 输出: [0,1,1]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 示例 2:
 * <p>
 * 输入: n = 5
 * 输出: [0,1,1,2,1,2]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 */
public class T003 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i >> 1] + i % 2;
        }
        return res;
    }

    /**
     * @param
     * @return
     * 时间复杂度 log（n * logn）
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = countOne(i);
        }
        return res;
    }

    private int countOne(int i) {
        int sum = 0;
        while (i > 0) {
            if (i % 2 == 1) {
                sum++;
            }
            i = i / 2;
        }
        return sum;
    }
     */

    public static void main(String[] args) {
        T003 t003 = new T003();
        int n = 5;
        System.out.println(Arrays.toString(t003.countBits(n)));
    }
}
