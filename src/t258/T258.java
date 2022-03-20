package t258;

/**
 * @Author Lyz
 * @Date: 2022/3/3 9:55
 * @Version 1.0
 * <p>
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num = 38
 * 输出: 2
 * 解释: 各位相加的过程为：
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * 由于2 是一位数，所以返回 2。
 * 示例 1:
 * <p>
 * 输入: num = 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T258 {
    public int addDigits(int num) {
        /**
         * f(ab) = f(a * 9 + a + b) = f(a + b)
         */
        return (num - 1) % 9 + 1;
    }

    public static void main(String[] args) {
        T258 t258 = new T258();
        int num = 38;
        System.out.println(t258.addDigits(num));
    }
}
