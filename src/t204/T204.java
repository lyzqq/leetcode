package t204;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * <p>
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：n = 1
 * 输出：0
 */
public class T204 {
    public int countPrimes(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res += isPrimes(i) ? 1 : 0;
        }
        return res;
    }

    public boolean isPrimes(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        T204 t204 = new T204();
        int n = 10;
        System.out.println(t204.countPrimes(n));
    }
}
