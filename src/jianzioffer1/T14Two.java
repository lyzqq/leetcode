package jianzioffer1;

/**
 * @Author Lyz
 * @Date: 2022/3/4 10:13
 * @Version 1.0
 * <p>
 * 剑指 Offer 14- I. 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 */
public class T14Two {

    public int cuttingRope(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        long a = 1;
        while (n > 4) {
            a = (a * 3) % 1000000007;
            n = n - 3;
        }
        return (int) (a * n % 1000000007);
    }

    public static void main(String[] args) {
        T14Two t14Two = new T14Two();
        int n = 20;
        System.out.println(t14Two.cuttingRope(n));
    }
}
