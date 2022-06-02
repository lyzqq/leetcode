package t386;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lyz
 * @Date: 2022/4/18 9:58
 * @Version 1.0
 * 386. 字典序排数
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 * 示例 1：
 * 输入：n = 13
 * 输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
 * 示例 2：
 * 输入：n = 2
 * 输出：[1,2]
 */
public class T386 {

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        int number = 1;
        for (int i = 0; i < n; i++) {
            list.add(number);
            if (number * 10 <= n) {
                number *= 10;
            } else {
                while (number % 10 == 9 || number + 1 > n) {
                    number /= 10;
                }
                number++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println(lexicalOrder(n));
    }
}
