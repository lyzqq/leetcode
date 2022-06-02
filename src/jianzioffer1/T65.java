package jianzioffer1;

/**
 * @Author Lyz
 * @Date: 2022/4/16 17:42
 * @Version 1.0
 * 剑指 Offer 65. 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * <p>
 * 示例:
 * <p>
 * 输入: a = 1, b = 1
 * 输出: 2
 */
public class T65 {
    public static int add(int a, int b) {
        // sum记录为进位的和 tmp记录进位
        int sum, tmp;
        do {
            sum = a ^ b;
            tmp = (a & b) << 1;
            a = sum;
            b = tmp;
        } while (tmp != 0);
        return sum;
    }

    public static void main(String[] args) {
        int a = 1, b = 1;
        System.out.println(add(a, b));
    }

}
