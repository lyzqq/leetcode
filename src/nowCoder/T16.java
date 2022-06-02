package nowCoder;

/**
 * @Author Lyz
 * @Date: 2022/4/27 20:17
 * @Version 1.0
 * <p>
 * JZ16 数值的整数次方
 * 描述
 * 实现函数 double Power(double base, int exponent)，求base的exponent次方。
 * <p>
 * 注意：
 * 1.保证base和exponent不同时为0。
 * 2.不得使用库函数，同时不需要考虑大数问题
 * 3.有特殊判题，不用考虑小数点后面0的位数。
 * 数据范围： |base| \le 100 \∣base∣≤100  ， |exponent| \le 100 \∣exponent∣≤100  ,保证最终结果一定满足 |val| \le 10^4 \∣val∣≤10
 * 4
 * 进阶：空间复杂度 O(1)\O(1)  ，时间复杂度 O(n)\O(n)
 * <p>
 * 示例1
 * 输入：2.00000,3
 * 返回值：8.00000
 * 示例2
 * 输入：2.10000,3
 * 返回值：9.26100
 * 示例3
 * 输入：2.00000,-2
 * 返回值：0.25000
 * 说明：2的-2次方等于1/4=0.25
 */
public class T16 {

    public static double Power(double base, int exponent) {
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        if (exponent == 0) return 1;
        double res = base;
        for (int i = 0; i < exponent - 1; i++) {
            res *= base;
        }
        return res;
    }

    public static void main(String[] args) {
        double base = 2.0000;
        int exponent = -3;
        System.out.println(Power(base, exponent));
    }
}
