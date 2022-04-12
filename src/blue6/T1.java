package blue6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Lyz
 * @Date: 2022/4/1 19:01
 * @Version 1.0
 * <p>
 * 7-1 愿天下有情人都是失散多年的兄妹 (20 分)
 * 呵呵。大家都知道五服以内不得通婚，即两个人最近的共同祖先如果在五代以内（即本人、父母、祖父母、曾祖父母、高祖父母）则不可通婚。本题就请你帮助一对有情人判断一下，他们究竟是否可以成婚？
 * <p>
 * 输入格式：
 * 输入第一行给出一个正整数N（2 ≤ N ≤10
 * 4
 * ），随后N行，每行按以下格式给出一个人的信息：
 * <p>
 * 本人ID 性别 父亲ID 母亲ID
 * 其中ID是5位数字，每人不同；性别M代表男性、F代表女性。如果某人的父亲或母亲已经不可考，则相应的ID位置上标记为-1。
 * <p>
 * 接下来给出一个正整数K，随后K行，每行给出一对有情人的ID，其间以空格分隔。
 * <p>
 * 注意：题目保证两个人是同辈，每人只有一个性别，并且血缘关系网中没有乱伦或隔辈成婚的情况。
 * <p>
 * 输出格式：
 * 对每一对有情人，判断他们的关系是否可以通婚：如果两人是同性，输出Never Mind；如果是异性并且关系出了五服，输出Yes；如果异性关系未出五服，输出No。
 * <p>
 * 输入样例：
 * 24
 * 00001 M 01111 -1
 * 00002 F 02222 03333
 * 00003 M 02222 03333
 * 00004 F 04444 03333
 * 00005 M 04444 05555
 * 00006 F 04444 05555
 * 00007 F 06666 07777
 * 00008 M 06666 07777
 * 00009 M 00001 00002
 * 00010 M 00003 00006
 * 00011 F 00005 00007
 * 00012 F 00008 08888
 * 00013 F 00009 00011
 * 00014 M 00010 09999
 * 00015 M 00010 09999
 * 00016 M 10000 00012
 * 00017 F -1 00012
 * 00018 F 11000 00013
 * 00019 F 11100 00018
 * 00020 F 00015 11110
 * 00021 M 11100 00020
 * 00022 M 00016 -1
 * 00023 M 10012 00017
 * 00024 M 00022 10013
 * 9
 * 00021 00024
 * 00019 00024
 * 00011 00012
 * 00022 00018
 * 00001 00004
 * 00013 00016
 * 00017 00015
 * 00019 00021
 * 00010 00011
 * 输出样例：
 * Never Mind
 * Yes
 * Never Mind
 * No
 * Yes
 * No
 * Yes
 * No
 * No
 */
public class T1 {
    static int n;
    static List<Integer>[] tab;
    static char[] sex;
    static int[] vis;
    static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        tab = new ArrayList[100005];
        sex = new char[100005];
        vis = new int[100005];

        for (int i = 1; i <= n; i++) {
            int id = sc.nextInt();
            tab[id] = new ArrayList<>();
            char ch = sc.next().charAt(0);
            sex[id] = ch;

            int fid = sc.nextInt();
            int mid = sc.nextInt();

            if (fid != -1) {
                tab[id].add(fid);
                sex[fid] = 'M';
            }
            if (mid != -1) {
                tab[id].add(mid);
                sex[mid] = 'F';
            }
        }
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (sex[a] == sex[b]) {
                System.out.println("Never Mind");
                continue;
            }

            Arrays.fill(vis, 0);
            flag = false;

            vis[a] = 1;
            vis[b] = 1;
            dfs(a, 1);
            dfs(b, 1);
            if (flag) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }

    private static void dfs(int v, int k) {
        if (flag || k > 5) {
            return;
        }

        if (vis[v] == 1) {
            flag = true;
        }

        List<Integer> ls = tab[v];

        if (ls == null) return;

        for (int i = 0; i < ls.size(); i++) {
            dfs(ls.get(i), k + 1);
        }
    }
}
