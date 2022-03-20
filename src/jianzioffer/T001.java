package jianzioffer;

/**
 * @Author Lyz
 * @Date: 2022/3/1 15:13
 * @Version 1.0
 * 剑指 Offer II 001. 整数除法
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 *
 * 注意：
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231−1]。本题中，如果除法结果溢出，则返回 231 − 1
 *
 * 示例 1：
 * 输入：a = 15, b = 2
 * 输出：7
 * 解释：15/2 = truncate(7.5) = 7
 * 示例 2：
 * 输入：a = 7, b = -3
 * 输出：-2
 * 解释：7/-3 = truncate(-2.33333..) = -2
 * 示例 3：
 * 输入：a = 0, b = 1
 * 输出：0
 * 示例 4：
 * 输入：a = 1, b = 1
 * 输出：1
 */
public class T001 {
    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        a = Math.abs(a);
        b = Math.abs(b);
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            // 首先，右移的话，再怎么着也不会越界
            // 其次，无符号右移的目的是：将-2147483648 看出 2147483648
            // 注意，这里不能是(a >>> i) >= b 而应该是(a >>> i) - b >= 0
            // 这个也是为了避免b = -2147483648，如果b = -2147483648
            // 那么(a >>> i) >= b永远为true，但是(a >>> i) - b >= 0 为false
            if ((a >>> i) - b >= 0) {
                a -= (b << i);
                // 代码优化；这里控制res大于等于INT_MAX
                if (res > Integer.MAX_VALUE - (1 << i)) {
                    return Integer.MIN_VALUE;
                }
                res += (1 << i);
            }
        }
        return sign == 1 ? res : -res;
    }

    public static void main(String[] args) {
        T001 t001 = new T001();
        int a = 15, b = 2;
        System.out.println(t001.divide(a, b));
    }
}
