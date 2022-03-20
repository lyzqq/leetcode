package t537;

/**
 * @Author Lyz
 * @Date: 2022/2/25 15:41
 * @Version 1.0
 * <p>
 * 537. 复数乘法
 * 复数 可以用字符串表示，遵循 "实部+虚部i" 的形式，并满足下述条件：
 * <p>
 * 实部 是一个整数，取值范围是 [-100, 100]
 * 虚部 也是一个整数，取值范围是 [-100, 100]
 * i2 == -1
 * 给你两个字符串表示的复数 num1 和 num2 ，请你遵循复数表示形式，返回表示它们乘积的字符串。
 * 示例 1：
 * 输入：num1 = "1+1i", num2 = "1+1i"
 * 输出："0+2i"
 * 解释：(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
 * 示例 2：
 * 输入：num1 = "1+-1i", num2 = "1+-1i"
 * 输出："0+-2i"
 * 解释：(1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。
 */
public class T537 {

    public String complexNumberMultiply(String num1, String num2) {
        String[] complex1 = num1.split("\\+|i");
        String[] complex2 = num2.split("\\+|i");
        int a = Integer.parseInt(complex1[0]);
        int b = Integer.parseInt(complex1[1]);
        int c = Integer.parseInt(complex2[0]);
        int d = Integer.parseInt(complex2[1]);
        return String.format("%d+%di", a * c - b * d, a * d + b * c);
    }

    public static void main(String[] args) {
        T537 t537 = new T537();
        String num1 = "1+1i", num2 = "1+1i";
        System.out.println(t537.complexNumberMultiply(num1, num2));
    }
}
