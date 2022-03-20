package blue4;

import javax.swing.tree.TreeNode;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Lyz
 * @Date: 2022/3/19 19:33
 * @Version 1.0
 * <p>
 * 选择整数1至n中m个数进行字典序全排列。
 * <p>
 * 输入格式:
 * 输入整数 n，m，0<m<n<10 。
 * <p>
 * 输出格式:
 * 输出所有m个数不重复的全排列，每一行输出一种排列情况，所有的排列情况按字典序输出。最后一行输出全排列的总数。
 * <p>
 * 输入样例:
 * 3 2
 * 输出样例:
 * 注意：除了输出的最后一行，其余每行最后有一个空格
 * <p>
 * 1 2
 * 1 3
 * 2 1
 * 2 3
 * 3 1
 * 3 2
 * 6
 */
public class T3 {
    static int m, n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
//        boolean[] visit = new boolean[n];
        int[] nums = new int[n];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            nums[i] = i + 1;
            //temp.add(i + 1);
        }
        boolean[] used = new boolean[n];
        int count = 0;
        backTrack(res, temp, used, count, nums);
       /* backTrack(res, temp, n, 0);
//        HashSet<List<Integer>> lists = new HashSet<>();
        // int count = 0;
        */
        List<List<Integer>> lists = new ArrayList<>();
        for (List<Integer> list : res) {
            for (int i = n - 1; i >= m; --i) {
                list.remove(i);
            }
            if (!lists.contains(list))  {
                lists.add(list);
            }
        }

        for (List<Integer> list : lists) {
            System.out.println(list);
        }
        System.out.println(lists.size());

        /*backTrack(res, temp, nums, visit);
        for (List<Integer> list : res) {
            for (int i = 0; i < n - m; ++i) {
                list.remove(m);
            }
        }
        int count = 1;
        List<Integer> list1 = res.get(0);
        for (int j = 0; j < m; ++j) {
            int num = list1.get(j);
            System.out.print(num + " ");
        }
        System.out.println();
        for (int i = 1; i < res.size(); ++i) {
            List<Integer> list = res.get(i);
            if (list.equals(res.get(i - 1))) continue;
            for (int j = 0; j < m; ++j) {
                int num = list.get(j);
                System.out.print(num + " ");
            }
            count++;
            System.out.println();
        }
        System.out.println(count);*/
    }
    public static void backTrack(List<List<Integer>> res, List<Integer> list, boolean[] used, int count, int[] nums) {
        if (count == nums.length) {
            res.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                backTrack(res, list, used, count + 1, nums);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }

    /*private static void backTrack(List<List<Integer>> res, List<Integer> temp, int n, int first) {
        if (first == n) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = first; i < n; ++i) {
            Collections.swap(temp, i, first);
            backTrack(res, temp, n, first + 1);
            Collections.swap(temp, i, first);
        }
    }*/

    /*public static void backTrack(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] visit) {
        if (temp.size() == nums.length) res.add(new ArrayList<>(temp));
        for (int i = 0; i < nums.length; ++i) {
            if (!visit[i]) {
                visit[i] = true;
                temp.add(nums[i]);
                backTrack(res, temp, nums, visit);
                visit[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }*/
}
