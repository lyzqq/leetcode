package t441;

import java.util.Scanner;

/**
 * @author 刘勇志
 * @version 1.0
 */
public class T441 {
    public int arrangeCoins(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
        /*int i = 1;
        while (n >= i) {
            n -= i;
            i++;
        }
        return i - 1;*/
    }

    public static void main(String[] args) {
        T441 t441 = new T441();
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = 8;
        System.out.println(t441.arrangeCoins(n));
    }
}
