package jianzioffer1;

/**
 * @Author Lyz
 * @Date: 2022/3/4 11:18
 * @Version 1.0
 * <p>
 * 剑指 Offer 16. 数值的整数次方
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 */
public class T16 {

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        double half = myPow(x , n / 2);
        double mod = myPow(x , n % 2);
        return half * half * mod;
    }

    public static void main(String[] args) {
        T16 t16 = new T16();
        double x = 2.0000;
        int n = 10;
        System.out.println(t16.myPow(x, n));
    }
}
