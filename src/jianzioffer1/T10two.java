package jianzioffer1;

/**
 * @Author Lyz
 * @Date: 2022/3/2 14:05
 * @Version 1.0
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 * <p>
 * 输入：n = 0
 * 输出：1
 */
public class T10two {
    public int numWays(int n) {
        if (n <= 1) return 1;
        if (n == 2) return 2;
        int p, q = 1, r = 2;
        for (int i = 3; i <= n; i++) {
            p = q;
            q = r;
            r = (p + q) % 1000000007;
        }
        return r;
    }

    public static void main(String[] args) {
        T10two t10two = new T10two();
        int n = 7;
        System.out.println(t10two.numWays(n));
    }
}
