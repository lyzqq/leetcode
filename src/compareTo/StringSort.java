package compareTo;

import java.util.Arrays;

/**
 * @Author Lyz
 * @Date: 2022/4/20 16:10
 * @Version 1.0
 * 字符串数组排序
 */
public class StringSort {

    public static void main(String[] args) {
        String s = "abc abd sda ss Rds Abs Ras!";

        String[] s1 = s.split(" ");

        int len1 = 0, len2 = 0;
        for (int i = 0; i < s1.length; i++) {
            if (s1[i].charAt(0) <= 'z' && s1[i].charAt(0) >= 'a') {
                len1++;
            }
            if (s1[i].charAt(0) <= 'Z' && s1[i].charAt(0) >= 'A') {
                len2++;
            }
        }
        String[] sa = new String[len1];
        String[] sA = new String[len2];
        int saL = 0, sAL = 0;
        for (int i = 0; i < s1.length; i++) {
            if (s1[i].charAt(0) <= 'z' && s1[i].charAt(0) >= 'a') {
                sa[saL++] = s1[i];
            }
            if (s1[i].charAt(0) <= 'Z' && s1[i].charAt(0) >= 'A') {
                sA[sAL++] = s1[i];
            }
        }
        sort(sa);
        sort(sA);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sa.length; i++) {
            sb.append(sa[i]).append(" ");
        }
        for (int i = sA.length - 1; i > 0; i--) {
            sb.append(sA[i]).append(" ");
        }
        sb.append(sA[0]);
        for (int i = 0; i < sb.length(); i++) {
            if (Character.isLetter(sb.charAt(i)) || sb.charAt(i) == ' ') {
                continue;
            } else {
                sb.deleteCharAt(i);
            }
        }
        System.out.println(sb.toString());
    }

    // 冒泡排序
    private static void sort(String[] s1) {
        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s1.length - 1 -i; j++) {
                if (s1[j].compareTo(s1[j + 1]) > 0) {
                    String temp = s1[j];
                    s1[j] = s1[j + 1];
                    s1[j + 1] = temp;
                }
            }
        }
    }
}
