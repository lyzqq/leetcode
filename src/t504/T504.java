package t504;

/**
 * @Author Lyz
 * @Date: 2022/3/7 11:42
 * @Version 1.0
 * 504. 七进制数
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 *
 * 示例 1:
 *
 * 输入: num = 100
 * 输出: "202"
 * 示例 2:
 *
 * 输入: num = -7
 * 输出: "-10"
 */
public class T504 {
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) return "0";
        boolean flag = num < 0;
        num = Math.abs(num);
        while (num != 0) {
            sb.append(num % 7);
            num /= 7;
        }
        if (flag) sb.append("-");
        return sb.reverse().toString();
//        return Integer.toString(num, 7);
    }

    public static void main(String[] args) {
        T504 t504 = new T504();
        int nums = 101;
        System.out.println(t504.convertToBase7(nums));
    }
}
