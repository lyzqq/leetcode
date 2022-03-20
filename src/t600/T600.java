package t600;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 600. 不含连续1的非负整数
 * 给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含 连续的1 的个数。
 * 示例 1:
 * 输入: 5
 * 输出: 5
 * 解释:
 * 下面是带有相应二进制表示的非负整数<= 5：
 * 0 : 0
 * 1 : 1
 * 2 : 10
 * 3 : 11
 * 4 : 100
 * 5 : 101
 * 其中，只有整数3违反规则（有两个连续的1），其他5个满足规则。
 */
public class T600 {
    public int findIntegers(int n) {
        int[] dp = new int[31];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < 31; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int pre = 0, res = 0;
        for (int i = 29; i >= 0; --i) {
            int val = 1 << i;
            if ((n & val) != 0) {
                n -= val;
                res += dp[i + 1];
                if (pre == 1) {
                    break;
                }
                pre = 1;
            } else {
                pre = 0;
            }

            if (i == 0) {
                ++res;
            }
        }

        return res;
    }
        /*if (n < 3) {
            return n + 1;
        }
        int res = 3;
        for (int i = 3; i <= n; i++) {
            if (isOne(i)) {
                res++;
            }
        }
        return res;
    }

    public boolean isOne(int n) {
//        if (n % 2 == 0) {
//            return true;
//        }
        int num = 0;
        while (n > 0){
            if (n % 2 == 0) {
                num = 0;
            } else {
                num += 1;
            }
            n = n >> 1;
            if (num == 2) {
                return false;
            }
        }
        return true;
    }*/

    public static void main(String[] args) {
        T600 t600 = new T600();
        int n = 5;
        System.out.println(t600.findIntegers(5));
    }
}
