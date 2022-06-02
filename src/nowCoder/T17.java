package nowCoder;

import java.util.Arrays;

/**
 * @Author Lyz
 * @Date: 2022/4/27 20:27
 * @Version 1.0
 * <p>
 * JZ17 打印从1到最大的n位数
 * 描述
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * 1. 用返回一个整数列表来代替打印
 * 2. n 为正整数，0 < n <= 5
 * 示例1
 * 输入：1
 * 返回值：[1,2,3,4,5,6,7,8,9]
 */
public class T17 {
    public static int[] printNumbers(int n) {
        // write code here
        int len = (int) Math.pow(10, n);
        int[] res = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(Arrays.toString(printNumbers(n)));
    }
}
