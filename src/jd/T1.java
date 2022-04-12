package jd;

import java.util.Scanner;

/**
 * @Author Lyz
 * @Date: 2022/4/2 19:45
 * @Version 1.0
 */
public class T1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        String S = sc.next();
        char[] chars = S.toCharArray();
        int res = X;
        for (char aChar : chars) {
            res = count(aChar, res);
        }
        System.out.println(res);
    }

    private static int count(char aChar, int res) {
        if (aChar == 'U') {
            return  res / 2;
        } else if (aChar == 'L') {
            return res * 2;
        } else {
            return res * 2 + 1;
        }
    }
}
