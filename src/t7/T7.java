package t7;

import static java.lang.Integer.parseInt;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 7. 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 */
public class T7 {
    public int reverse(int x) {
        int res;
        String s = Integer.toString(x);
        StringBuilder s1 = new StringBuilder(s).reverse();
        if (x < 0) {
            s1 = s1.insert(0, "-");
            s1 = s1.deleteCharAt(s1.length() - 1);
        }
        try {
            res = Integer.parseInt(s1.toString());
            return res;
        } catch (NumberFormatException e) {
            return 0;
        }


//        int res = 0;
//        while (x != 0) {
//            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
//                return 0;
//            }
//            int num = x % 10;
//            x /= 10;
//            res = num + res * 10;
//        }

//            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
//                    return 0;
//            }

    }

    public static void main(String[] args) {
        T7 t7 = new T7();
        System.out.println(t7.reverse(-123456));
        System.out.println(t7.reverse(124500));
        System.out.println(t7.reverse(1534236469));
        System.out.println(t7.reverse(-2147483412));
//        System.out.println(t7.reverse(-8463847412));-2147483648
        System.out.println(t7.reverse(-2147483648));
    }
}
