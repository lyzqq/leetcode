package jd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Lyz
 * @Date: 2022/4/2 19:50
 * @Version 1.0
 */
public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n1 = sc.nextInt();
            String s = sc.next();
            char[] c1 = s.toCharArray();
            /*char[] c1 = new char[3 * n1];
            for (int i = 0; i < c1.length; i++) {
                c1[i] = sc.next().charAt(0);
            }*/
            System.out.println(count(c1));
            T--;
        }
    }

    private static int count(char[] c) {
        int len = c.length;
        int countA = 0, countB = 0, countC = 0;
        for (char c1 : c) {
            if (c1 == 'A') countA++;
            if (c1 == 'B') countB++;
            if (c1 == 'C') countC++;
        }
        if (countA == countB && countA == countC) {
            return 0;
        }
        int tempA = (len / 3) - countA;
        int tempB = (len / 3) - countB;
        int tempC = (len / 3) - countC;
        int res;
        if (tempA < 0 && tempB > 0 && tempC > 0) {
            // 针对除参数外的另外两种字母
            res = cc1(tempA, 'A', c);
        } else if (tempA < 0 && tempB > 0 && tempC == 0) {
            // 只针对B
            res = cc2(tempA, 'B', c);
        } else if (tempA < 0 && tempB == 0 && tempC > 0) {
            // 只针对C
            res = cc2(tempA, 'C', c);
        } else if (tempA > 0 && tempB < 0 && tempC > 0) {
            res = cc1(tempB, 'B', c);
        } else if (tempA == 0 && tempB < 0 && tempC > 0) {
            // 针对C
            res = cc2(tempB, 'C', c);
        } else if (tempA > 0 && tempB < 0 && tempC == 0) {
            // 针对A
            res = cc2(tempB, 'A', c);
        } else if (tempA > 0 && tempB > 0 && tempC < 0) {
            res = cc1(tempC, 'C', c);
        } else if (tempA == 0 && tempB > 0 && tempC < 0) {
            // 针对B
            res = cc2(tempC, 'B', c);
        } else if (tempA > 0 && tempB == 0 && tempC < 0) {
            // 针对A
            res = cc2(tempC, 'A', c);
        } else if (tempA < 0 && tempB < 0 && tempC > 0) {
            // 针对C
            res = cc2((tempA + tempB), 'C', c);
        } else if (tempA < 0 && tempB > 0 && tempC < 0) {
            // 针对B
            res = cc2((tempA + tempC), 'B', c);
        } else {
            // 针对A
            res = cc2((tempB + tempC), 'A', c);
        }
        return res;
    }


    // 针对除参数外的另外两种字母
    private static int cc1(int tempA, char a, char[] c) {
        int len = c.length;
        int[] nums = new int[len];
        int i = 0;
        for (char c1 : c) {
            if (c1 != a) {
                nums[i]++;
            } else {
                i++;
            }
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int j = nums.length - 1; j >= 0; j--) {
            sum += nums[j];
            if (sum + tempA >= 0) {
                return nums.length - j + 1;
            }
        }
        return 0;
    }

    // 只针对一个字符
    private static int cc2(int tempA, char b, char[] c) {
        int len = c.length;
        int[] nums = new int[len];
        int i = 0;
        for (char c1 : c) {
            if (c1 == b) {
                nums[i]++;
            } else {
                i++;
            }
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int j = nums.length - 1; j >= 0; j--) {
            sum += nums[j];
            if (sum + tempA >= 0) {
                return nums.length - j + 1;
            }
        }
        return 0;
    }

    /*
    import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n1 = sc.nextInt();
            char[] c1 = new char[3 * n1];
            for (int i = 0; i < c1.length; i++) {
                c1[i] = sc.next().charAt(0);
            }
            System.out.println(count(c1));
            T--;
        }
    }

    private static int count(char[] c) {
        int len = c.length;
        int countA = 0, countB = 0, countC = 0;
        for (char c1 : c) {
            if (c1 == 'A') countA++;
            if (c1 == 'B') countB++;
            if (c1 == 'C') countC++;
        }
        if (countA == countB && countA == countC) {
            return 0;
        }
        int tempA = (len / 3) - countA;
        int tempB = (len / 3) - countB;
        int tempC = (len / 3) - countC;
        return 2;
    }
}

     */

}
