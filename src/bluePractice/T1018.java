package bluePractice;

import java.util.Scanner;

/**
 * @Author Lyz
 * @Date: 2022/4/8 17:18
 * @Version 1.0
 * 1018 锤子剪刀布 (20 分)
 * 大家应该都会玩“锤子剪刀布”的游戏：两人同时给出手势，胜负规则如图所示：
 *
 * FigCJB.jpg
 *
 * 现给出两人的交锋记录，请统计双方的胜、平、负次数，并且给出双方分别出什么手势的胜算最大。
 *
 * 输入格式：
 * 输入第 1 行给出正整数 N（≤10
 * 5
 *  ），即双方交锋的次数。随后 N 行，每行给出一次交锋的信息，即甲、乙双方同时给出的的手势。C 代表“锤子”、J 代表“剪刀”、B 代表“布”，第 1 个字母代表甲方，第 2 个代表乙方，中间有 1 个空格。
 *
 * 输出格式：
 * 输出第 1、2 行分别给出甲、乙的胜、平、负次数，数字间以 1 个空格分隔。第 3 行给出两个字母，分别代表甲、乙获胜次数最多的手势，中间有 1 个空格。如果解不唯一，则输出按字母序最小的解。
 */
public class T1018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] chars = new char[N][2];
        while (N-- != 0) {
            chars[N][0] = sc.next().charAt(0);
            chars[N][1] = sc.next().charAt(0);
        }
        sc.close();
    }
}
