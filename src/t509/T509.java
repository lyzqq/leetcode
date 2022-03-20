package t509;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 509. 斐波那契数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 * 示例 1：
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 示例 2：
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 示例 3：
 * <p>
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 */
public class T509 {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int num = 1, res = 1, tem;
        for (int i = 3; i <= n; i++) {
            tem = num;
            num = res;
            res = tem + res;
        }
        return res;
    }

    public static void main(String[] args) {
        T509 t509 = new T509();
        int n = 4;
        System.out.println(t509.fib(n));
    }
}
