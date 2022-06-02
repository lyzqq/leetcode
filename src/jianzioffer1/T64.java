package jianzioffer1;

/**
 * @Author Lyz
 * @Date: 2022/4/16 17:33
 * @Version 1.0
 * 剑指 Offer 64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * 示例 1：
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 * 输入: n = 9
 * 输出: 45
 */
public class T64 {

//    static int[] test = new int[]{0};
    public static int sumNums(int n) {
        try {
//            return test[n];
            int a[] = new int[n];
            return n + sumNums(n - 1);
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println(sumNums(n));
    }
}
