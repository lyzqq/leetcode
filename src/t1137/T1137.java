package t1137;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 1137. 第 N 个泰波那契数
 * 泰波那契序列 Tn 定义如下：
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在n >= 0 的条件下
 * Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * 示例 1：
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 * 输入：n = 25
 * 输出：1389537
 */
public class T1137 {
    public int tribonacci(int n) {
        if (n < 2) return n;
        int num0 = 0, num1 = 1, res = 1, tem;
        for (int i = 3; i <= n; i++) {
            tem = num0;
            num0 = num1;
            num1 = res;
            res = tem + num0 + num1;
        }
        return res;
    }

    public static void main(String[] args) {
        T1137 t1137 = new T1137();
        System.out.println(t1137.tribonacci(25));
    }
}
