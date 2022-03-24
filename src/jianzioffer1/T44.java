package jianzioffer1;

/**
 * @Author Lyz
 * @Date: 2022/3/23 9:07
 * @Version 1.0
 * 剑指 Offer 44. 数字序列中某一位的数字
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * <p>
 * 请写一个函数，求任意第n位对应的数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：n = 11
 * 输出：0
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= n < 2^31
 * 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/
 */
public class T44 {
    public int findNthDigit(int n) {
        int len = 1;
        while (len * 9 * Math.pow(10, len - 1) < n) {
            n -= len * 9 * Math.pow(10, len - 1);
            len++;
        }
        long s = (long) Math.pow(10, len - 1);
        s += n / len - 1;
        n -= len * (n / len);
        return (int) (n == 0 ? (s % 10) : ((s + 1)/ Math.pow(10, len - n) % 10));
    }

    public static void main(String[] args) {
        T44 t44 = new T44();
        int n = 55;
        System.out.println(t44.findNthDigit(n));
    }
}
