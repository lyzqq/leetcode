package t367;

/**
 * @author 刘勇志
 * @version 1.0
 * 367. 有效的完全平方数
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false。
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 *
 * 示例 1：
 * 输入：num = 16
 * 输出：true
 * 示例 2：
 * 输入：num = 14
 * 输出：false
 */
public class T367 {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        long left = 1, right = num / 2;
        while (left <= right) {
            long mid = (left + right) >> 1;
            if ( mid * mid < num) {
                left = mid + 1;
            } else if (mid * mid > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        T367 t367 = new T367();
        // int num = 25;
        int num = 808201;
        //int num = 1;
        System.out.println(t367.isPerfectSquare(num));
    }
}
