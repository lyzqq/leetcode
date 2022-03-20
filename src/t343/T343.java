package t343;

/**
 * @Author Lyz
 * @Date: 2022/3/4 10:31
 * @Version 1.0
 *
 * 343. 整数拆分
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 *
 * 返回 你可以获得的最大乘积 。
 *
 * 示例 1:
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 */
public class T343 {

    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int a = 1;
        while(n > 4) {
            n = n - 3;
            a = a * 3;
        }
        return  a * n;
    }

    public static void main(String[] args) {
        T343 t343 = new T343();
        int n = 10;
        System.out.println(t343.integerBreak(n));
    }
}
