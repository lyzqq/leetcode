package t371;

/**
 * @author 刘勇志
 * @version 1.0
 * 371. 两整数之和
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。
 * <p>
 * 示例 1：
 * 输入：a = 1, b = 2
 * 输出：3
 * 示例 2：
 * 输入：a = 2, b = 3
 * 输出：5
 */
public class T371 {
    public int getSum(int a, int b) {
        int sum, carry;
        sum = a ^ b;
        carry = (a & b) << 1;
        if (carry != 0) {
            return getSum(sum, carry);
        }
        return sum;
    }

    public static void main(String[] args) {
        T371 t371 = new T371();
//        int a = 1, b = 2;
        int a = 3, b = 3;
        System.out.println(t371.getSum(a, b));
    }
}
