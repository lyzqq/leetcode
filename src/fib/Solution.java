package fib;

/**
 * @author 刘勇志
 * @version 1.0
 */
public class Solution {
    public static int fib(int n) {
        if (n < 2) return n;
        int num = 1, res = 1, tem;
        for (int i = 3; i <= n; i++) {
            tem = num;
            num = res;
            res = (num + tem) % 1000000007;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
    }
}
