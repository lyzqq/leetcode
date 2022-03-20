package Offer10two;

/**
 * @author 刘勇志
 * @version 1.0
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class Solution {
    public static int numWays(int n) {
        if (n == 2) return 1;
        int num = 0, res = 1, tem;
        for (int i = 1; i <= n; i++) {
            tem = num;
            num = res;
            res = (num + tem) % 1000000007;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numWays(3));
    }

}
