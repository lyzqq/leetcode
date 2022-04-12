package t693;

/**
 * @Author Lyz
 * @Date: 2022/3/28 20:22
 * @Version 1.0
 * 693. 交替位二进制数
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 * 示例 1：
 * <p>
 * 输入：n = 5
 * 输出：true
 * 解释：5 的二进制表示是：101
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：false
 * 解释：7 的二进制表示是：111.
 * 示例 3：
 * <p>
 * 输入：n = 11
 * 输出：false
 * 解释：11 的二进制表示是：1011.
 */
public class T693 {

    public static boolean hasAlternatingBits(int n) {

        // 101010右移一位得到010101
        // 二者异或得到111111;
        // 111111加1为1000000
        // 两者按位与结果为0
        int m = n ^ (n >> 1);
        return (m & (m + 1)) == 0;
    }

    public static void main(String[] args) {
        int num = 7;
        System.out.println(hasAlternatingBits(num));
    }
}
