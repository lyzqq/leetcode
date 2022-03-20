package blue2;

/**
 * @Author Lyz
 * @Date: 2022/3/11 19:52
 * @Version 1.0
 *
 * 本题总分: 10分
 *
 * [问题描述]
 * 设有字符串 X，我们称在 X 的头尾及中间插入任意多个空格后构成的新字符串为 X 的扩展串，如字符串 X 为abcbcd，则字符串abcb□cd，□a□bcbcd□和abcb□cd□ 都是 X 的扩展串，这里□代表空格字符。
 *
 * 如果 A 是字符串 A 的扩展串，B
 *  是字符串 B 的扩展串，A  与 B
 *  具有相同的长度，那么我们定义字符串 A 与 B
 *  的距离为相应位置上的字符的距离总和，而两个非空格字符的距离定义为它们的 ASCII 码的差的绝对值，而空格字符与其他任意字符之间的距离为已知的定值K，空格字符与空格字符的距离为 0。
 *
 * 在字符串 A、B 的所有扩展串中，必定存在两个等长的扩展串 A，B  ，使得 A与 B 之间的距离达到最小，我们将这一距离定义为字符串 A，B 的距离。
 *
 * 请你求出字符串 A，B 的距离。
 *
 * 输入
 * 输入第一行为字符串 A ，第二行为字符串 B。A，B 均由小写字母组成 。第三行为一个整数 K，表示空格与其他字符的距离。
 *
 * 输入数据（即D.in）内容如下：
 */
public class T3 {

    public static void main(String[] args) {
        StringBuilder a = new StringBuilder("ufhwekfiwkbfkeigethneruikynenituwgntrhgrrth");
        StringBuilder b = new StringBuilder("trhgertgjhiowrwclmhneirughknigtmruibrdbhdsbrtbrdtberhthgtyrjytujyutj");
        a.insert(0,' ');
        b.insert(0,' ');
        int k = 2;
        long[][] f = new long[2000][2000];

        int alen = a.length();
        int blen = b.length();
        f[0][0] = 0;
        for (int i = 1; i <= alen; i++) f[i][0] = f[i - 1][0] + k;
        for (int i = 1; i <= blen; i++) f[0][i] = f[0][i - 1] + k;
        for (int i = 1; i <= alen; i++) {
            for (int j = 1; j <= blen; j++) {
                f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + Math.abs(a.charAt(i - 1) - b.charAt(j - 1)));
                f[i][j] = Math.min(f[i][j], f[i - 1][j] + k);
                f[i][j] = Math.min(f[i][j], f[i][j - 1] + k);
            }
        }
        System.out.println(f[alen - 1][blen]);
    }
}
