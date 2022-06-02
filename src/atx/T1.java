package atx;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author Lyz
 * @Date: 2022/4/21 18:57
 * @Version 1.0
 * <p>
 * 1/5
 * [编程题]朋友圈(后端开发卷)
 * 时间限制：C/C++ 2秒，其他语言4秒
 * 空间限制：C/C++ 256M，其他语言512M
 * 现在有 105 个用户，编号为 1- 105，现在已知有 m 对关系，每一对关系给你两个数 x 和 y ，
 * 代表编号为 x 的用户和编号为 y 的用户是在一个圈子中，
 * 例如： A 和 B 在一个圈子中， B 和 C 在一个圈子中，
 * 那么 A , B , C 就在一个圈子中。现在想知道最多的一个圈子内有多少个用户。
 * 数据范围：1 <= m <= 2* 10 ^ 6
 * 进阶：空间复杂度 O(n)，时间复杂度O(nlogn)
 * 输入描述:
 * 第一行输入一个整数T，接下来有T组测试数据。
 * 对于每一组测试数据：第一行输入1个整数n，代表有n对关系。
 * 接下来n行，每一行输入两个数x和y，代表编号为x和编号为y的用户在同一个圈子里。
 * 1 ≤ T ≤ 10
 * 1 ≤ n ≤ 2*106
 * 1 ≤ x, y ≤ 105
 * <p>
 * 输出描述:
 * 对于每组数据，输出一个答案代表一个圈子内的最多人数
 * <p>
 * 输入例子1:
 * 2
 * 4
 * 1 2
 * 3 4
 * 5 6
 * 1 6
 * 4
 * 1 2
 * 3 4
 * 5 6
 * 7 8
 * <p>
 * 输出例子1:
 * 4
 * 2
 */
public class T1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // t组数据
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt(); // n对关系
            HashMap<Integer, Integer> map = new HashMap<>(); // 用户数字 到 数组位置 的映射
            int[] check = new int[n * 2]; // 并查集数组（n对，最多 n * 2 个用户）

            for (int j = 0; j < n * 2; j++) {
                // 初始化并查集，指向自己
                check[j] = j;
            }

            for (int j = 0; j < n; j++) {
                // 建立并查集
                // 读入用户对
                int a = sc.nextInt();
                int b = sc.nextInt();
                int x = map.getOrDefault(a, map.size()); // 找到映射
                map.put(a, x);
                int y = map.getOrDefault(b, map.size());
                map.put(b, y);

                if (find(check, x) != x && find(check, y) != y) {
                    // 当都有根，从根部联通两并查集，能减少find的次数
                    // (连接方式未优化）
                    check[find(check, x)] = find(check, y);
                } else if (find(check, x) != x) {
                    // 只要一方有根，另一方直接连到根；都没根时一样
                    check[y] = find(check, x);
                } else {
                    check[x] = find(check, y);
                }
            }
            // 并查集根 和 并查集节点个数 的映射
            HashMap<Integer, Integer> res = new HashMap<>();
            for (int j = 0; j < n * 2; j++) {
                // 遍历并查集
                int k = find(check, j); // 找到当前节点的根
                res.put(k, res.getOrDefault(k, 0) + 1); // 节点个数加1
            }

            int max = 0;
            for (Integer value : res.values()) {
                max = Math.max(max, value);
            }
            System.out.println(max);
        }
    }


    private static int find(int[] check, int i) {
        if (check[i] != i) {
            // 当前节点非根
            check[i] = find(check, check[i]); // 当前节点指向根（路径压缩）
        }
        return check[i];
    }
}
