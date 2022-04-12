package bluePractice;

import java.util.*;

/**
 * @Author Lyz
 * @Date: 2022/4/7 15:00
 * @Version 1.0
 *
 * 读入一个正整数 n，计算其各位数字之和，用汉语拼音写出和的每一位数字。
 *
 * 输入格式：
 * 每个测试输入包含 1 个测试用例，即给出自然数 n 的值。这里保证 n 小于 10
 * 100
 *  。
 *
 * 输出格式：
 * 在一行内输出 n 的各位数字之和的每一位，拼音数字间有 1 空格，但一行中最后一个拼音数字后没有空格。
 */
public class T1002 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        long num = sc.nextLong();
        String s = sc.next();
        char[] chars = s.toCharArray();
        Map<Integer, String> map = new HashMap<>();
        map.put(0,"ling");
        map.put(1,"yi");
        map.put(2,"er");
        map.put(3,"san");
        map.put(4,"si");
        map.put(5,"wu");
        map.put(6,"liu");
        map.put(7,"qi");
        map.put(8,"ba");
        map.put(9,"jiu");
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += chars[i] - '0'; // 转成int
        }
//        int sum = 0;
//        while (num != 0) {
//            long temp = num % 10;
//            num /= 10;
//            sum += temp;
//        }
        List<Integer> list = new ArrayList<>();
        while (sum != 0) {
            list.add(sum % 10);
            sum /= 10;
        }
        Object[] array = list.toArray();
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i > 0; i--) {
            sb.append(map.get(array[i])).append(" ");
        }
        sb.append(map.get(array[0]));
        System.out.println(sb.toString());
    }
}
