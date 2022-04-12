package bluePractice;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Author Lyz
 * @Date: 2022/4/7 21:35
 * @Version 1.0
 * 给定一系列正整数，请按要求对数字进行分类，并输出以下 5 个数字：
 * <p>
 * A1 = 能被 5 整除的数字中所有偶数的和；
 * A2 = 将被 5 除后余 1 的数字按给出顺序进行交错求和，即计算 n1−n2 +n3−n4⋯；
 * A3= 被 5 除后余 2 的数字的个数；
 * A4 = 被 5 除后余 3 的数字的平均数，精确到小数点后 1 位；
 * A5  = 被 5 除后余 4 的数字中最大数字。
 * 输入格式：
 * 每个输入包含 1 个测试用例。每个测试用例先给出一个不超过 1000 的正整数 N，随后给出 N 个不超过 1000 的待分类的正整数。数字间以空格分隔。
 * <p>
 * 输出格式：
 * 对给定的 N 个正整数，按题目要求计算 A1~A5
 * 并在一行中顺序输出。数字间以空格分隔，但行末不得有多余空格。
 * 若分类之后某一类不存在数字，则在相应位置输出 N。
 * <p>
 * 输入样例 1：
 * 13 1 2 3 4 5 6 7 8 9 10 20 16 18
 * 输出样例 1：
 * 30 11 2 9.7 9
 * 输入样例 2：
 * 8 1 2 4 5 6 7 9 16
 * 输出样例 2：
 * N 11 2 N 9
 */
public class T1012 {

    static boolean flag = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int[] res;
        res = count(nums);
        check(res);
        double res4 = count4(nums);
        if (res4 != 0) {
            System.out.print(res4);
        } else {
            System.out.print("N");
        }
        System.out.print(" ");
        if (res[3] != 0) {
            System.out.println(res[3]);
        } else {
            System.out.println("N");
        }
    }


    private static void check(int[] res) {
        for (int i = 0; i < res.length - 1; i++) {
            if (i == 1) {
                if (flag) {
                    System.out.print(res[i]);
                } else {
                    System.out.print("N");
                }
            } else {
                if (res[i] != 0) {
                    System.out.print(res[i]);
                } else {
                    System.out.print("N");
                }
            }

            System.out.print(" ");
        }
    }

    private static int[] count(int[] nums) {
        int[] res = new int[4];
        int res1 = 0,  count2 = 0, res3 = 0;
        int res2 = 0;
        int res5 = 0;
        for (int num : nums) {
            // A1 = 能被 5 整除的数字中所有偶数的和；
            if (num % 5 == 0 && num % 2 == 0) {
                res1 += num;
            } else if (num % 5 == 1) {
                flag = true;
                // A2 = 将被 5 除后余 1 的数字按给出顺序进行交错求和，即计算 n1−n2 +n3−n4⋯；
                if (count2 % 2 == 0) {
                    res2 += num;
                } else {
                    res2 -= num;
                }
                count2++;
            } else if (num % 5 == 2) {
                // A3= 被 5 除后余 2 的数字的个数；
                res3++;
            } else if (num % 5 == 4) {
                // A5  = 被 5 除后余 4 的数字中最大数字。
                res5 = Math.max(res5, num);
            }

        }
        res[0] = res1;
        if (flag) {
            res[1] = res2;
        }
        res[2] = res3;
        res[3] = res5;
        return res;
    }

    private static double count4(int[] nums) {
        // A4 = 被 5 除后余 3 的数字的平均数，精确到小数点后 1 位；
        double res4 = 0, count4 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 5 == 3) {
                res4 += nums[i];
                count4++;
            }
        }
        if (count4 != 0) {
            res4 = new BigDecimal(res4 / count4).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        } else {
            res4 = 0;
        }
        return res4;
    }
}
