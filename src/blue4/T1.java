package blue4;

import java.util.Scanner;

/**
 * @Author Lyz
 * @Date: 2022/3/19 19:02
 * @Version 1.0
 *
 * Draw a rhombus. (绘制一个菱形。)
 *
 * Input:
 * Input an odd number n and 1<=n<100. （输入一个奇数n，1<=n<100。）
 *
 * Output:
 * Print a n rows n columns rhombus with many "." and "*". （输出一个由很多点和星组成的n行n列的菱形）
 *
 * Input Example:
 * Here is a set of inputs. For example:
 *
 * 5
 * Output Example:
 * The corresponding output is given here. For example:
 *
 * ..*..
 * .***.
 * *****
 * .***.
 * ..*..
 */
public class T1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println("*");
            return;
        }
        StringBuilder[] sbs = new StringBuilder[n];
        for (int i = 0; i < (n + 1) / 2; i++) {
            sbs[i] = new StringBuilder("a");
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int j = 0; j < (n - (2 * i + 1)) / 2; j++) {
                sb1.append('.');
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                sb2.append('*');
            }
            sbs[i] = sbs[i].append(sb1).append(sb2).append(sb1);
            sbs[i] = sbs[i].deleteCharAt(0);
            System.out.println(sbs[i]);
        }
        for (int i = (n - 2) / 2; i >= 0; i--) {
            System.out.println(sbs[i]);
        }
    }
}
