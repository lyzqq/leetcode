package t479;

/**
 * @Author Lyz
 * @Date: 2022/4/16 10:36
 * @Version 1.0
 */
public class T479 {

    public static int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }

        int upper = (int) (Math.pow(10, n) - 1);
        int ans = 0;
        for (int left = upper; ans == 0; --left) {
            long p = left;
            for (int x = left; x > 0; x /= 10) {
                p = p * 10 + x % 10;
            }
            for (long x = upper; x * x >= p; --x) {
                if (p % x == 0) {
                    // x是p的因子
                    ans = (int) (p % 1337);
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(largestPalindrome(n));
    }
}
