package bluePractice;

import java.util.Scanner;

/**
 * @Author Lyz
 * @Date: 2022/4/7 20:04
 * @Version 1.0
 * 1008 数组元素循环右移问题 (20 分)
 * 一个数组A中存有N（>0）个整数，在不允许使用另外数组的前提下，将每个整数循环向右移M（≥0）个位置，即将A中的数据由（A
 * 0A 1 ⋯A
 * N−1）变换为（A
 * N−M ⋯A N−1
 *  A0A1⋯A
 * N−M−1）（最后M个数循环移至最前面的M个位置）。如果需要考虑程序移动数据的次数尽量少，要如何设计移动的方法？
 *
 * 输入格式:
 * 每个输入包含一个测试用例，第1行输入N（1≤N≤100）和M（≥0）；第2行输入N个整数，之间用空格分隔。
 *
 * 输出格式:
 * 在一行中输出循环右移M位以后的整数序列，之间用空格分隔，序列结尾不能有多余空格。
 */
public class T1008 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        M = M % N;
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int[] tem = new int[M];
        int c = 0;
        for (int i = N - M; i < N; i++) {
            tem[c++] = nums[i];
        }
        int[] res = new int[N];
        int d = 0;
        for (int i = 0; i < N; i++) {
            if (i < M) {
                res[i] = tem[i];
            } else {
                res[i] = nums[d++];
            }
        }
        for (int i = 0; i < N - 1; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println(res[res.length - 1]);
    }
}
