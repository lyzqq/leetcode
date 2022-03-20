package jianzioffer1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author Lyz
 * @Date: 2022/3/18 12:13
 * @Version 1.0
 * <p>
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 */
public class T38 {

    public String[] permutation(String s) {
        Set<String> list = new HashSet<>();
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[arr.length];
        dfs(arr, sb, visited, list);
        return list.toArray(new String[0]);
    }

    public void dfs(char[] arr, StringBuilder sb, boolean[] visited, Set<String> list) {
        if (sb.length() == arr.length) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            dfs(arr, sb.append(arr[i]), visited, list);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        T38 t38 = new T38();
        String a = "abc";
        System.out.println(Arrays.toString(t38.permutation(a)));
    }
}
