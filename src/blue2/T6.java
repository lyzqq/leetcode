package blue2;

import java.util.Scanner;

/**
 * @Author Lyz
 * @Date: 2022/3/11 20:28
 * @Version 1.0
 *
 * 7-2 h0138. 疯牛 (15 分)
 * 农夫John建造了一个新的长谷仓，其中有N个（2 <= N <= 100,000）摊位。档位沿直线位于位置x1，...，xN（0 <= xi <= 1,000,000,000）。
 *
 * 他的C（2 <= C <= N）头母牛不喜欢这种谷仓布局，一旦放到摊子里就会变得互相攻击。为了防止母牛互相伤害，John希望将母牛分配给摊位，以使它们之间的最小距离尽可能大。最大最小距离是多少？
 *
 * 输入格式:
 * 第1行：两个以空格分隔的整数：N和C
 *
 * 第2..N + 1行：第i + 1行包含整数停滞位置xi
 *
 * 输出格式:
 * 一个整数：最大最小距离
 *
 * 输入样例:
 * 5 3
 * 1
 * 2
 * 8
 * 4
 * 9
 * 输出样例:
 * 3
 */
public class T6 {

    static int c, n;
    static int[] nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }
        System.out.println(T6.getAns());
    }

    private static int getAns() {
        int left = 0, right = nums[n - 1] - nums[0];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (judge(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }

    private static boolean judge(int mid) {
        int cnt = 1, tmp = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] - tmp >= mid) {
                cnt++;
                tmp = nums[i];
                if (cnt >= c) {
                    return true;
                }
            }
        }
        return false;
    }
}
