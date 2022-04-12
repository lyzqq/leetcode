package bluePractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Lyz
 * @Date: 2022/4/7 20:21
 * @Version 1.0
 * 1010 一元多项式求导 (25 分)
 * 设计函数求一元多项式的导数。（注：x
 * n
 *  （n为整数）的一阶导数为nx
 * n−1
 *  。）
 *
 * 输入格式:
 * 以指数递降方式输入多项式非零项系数和指数（绝对值均为不超过 1000 的整数）。数字间以空格分隔。
 *
 * 输出格式:
 * 以与输入相同的格式输出导数多项式非零项的系数和指数。数字间以空格分隔，但结尾不能有多余空格。注意“零多项式”的指数和系数都是 0，但是表示为 0 0。
 *
 * 输入样例:
 * 3 4 -5 2 6 1 -2 0
 * 输出样例:
 * 12 3 -10 1 6 0
 */
public class T1010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        while (sc.hasNext()) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            if (num2 != 0) {
                if (!flag) flag = true;
                else System.out.print(" ");
                System.out.print((num1 * num2) + " " + (num2 - 1));
            }
        }
        if (!flag) {
            System.out.print("0 0");
        }
        /*List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        String[] s = sc.nextLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            list.add(Integer.parseInt(s[i]));
        }
        for (int i = 0; i < list.size(); i += 2) {
            if (list.get(i) * list.get(i + 1)  != 0) {
                res.add(list.get(i) * list.get(i + 1));
                res.add(list.get(i + 1) - 1);
            }
        }
        for (int i = 0; i < res.size() - 1; i++) {
            System.out.print(res.get(i) + " ");
        }*/
//        System.out.println(res.get(res.size() - 1));
    }
}
