package nowCoder;

/**
 * @Author Lyz
 * @Date: 2022/4/26 20:58
 * @Version 1.0
 * JZ14 剪绳子
 * 描述
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长的 m 段（ m 、 n 都是整数， n > 1 并且 m > 1 ， m <= n ），
 * 每段绳子的长度记为 k[1],...,k[m] 。请问 k[1]*k[2]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是 8 时，我们把它剪成长度分别为 2、3、3 的三段，此时得到的最大乘积是 18 。
 * 数据范围： 2 \le n \le 602≤n≤60
 * 进阶：空间复杂度 O(1)O(1) ，时间复杂度 O(n)O(n)
 * 输入描述：
 * 输入一个数n，意义见题面。
 * 返回值描述：
 * 输出答案。
 * 示例1
 * 输入：8
 * 返回值：18
 * 说明：8 = 2 +3 +3 , 2*3*3=18
 * 示例2
 * 输入：2
 * 返回值：1
 * 说明：m>1，所以切成两段长度是1的绳子
 */
public class T14 {

    public static int cutRope (int n) {
        // write code here
        if (n <= 3) {
            return n - 1;
        }
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println(cutRope(n));
    }
}
