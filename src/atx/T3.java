package atx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author Lyz
 * @Date: 2022/4/21 21:27
 * @Version 1.0
 * 求抛物线 y^2 = 2Ax 与直线 y = Bx + C 所围成的封闭图形面积.若图形不存在,则输出
 * <p>
 * 输入描述:
 * 第一行输入一个正整数T.表示测试数据组数.
 * 接下来每行输入三个整数A , B和 C.
 * 1<=T<=1000
 * 1<=A,B<=100
 * -100<=C<=100
 * <p>
 * 输出描述:
 * 每组测试数据输出一个答案.在<1e-4范围内都视为正确输出.
 * <p>
 * 输入例子1:
 * 1
 * 1 1 -6
 * 输出例子1:
 * 31.2481110540
 */
public class T3 {

    private static double A = 0;
    private static double B = 0;
    private static double C = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] params = br.readLine().split(" ");
            A = Double.parseDouble(params[0]);
            B = Double.parseDouble(params[1]);
            C = Double.parseDouble(params[2]);
            if (A * A - 2 * A * B * C < 0) {
                System.out.println(0);
            } else {
                double lb = (A - Math.sqrt(A * A - 2 * A * B * C)) / B;
                double ub = (A + Math.sqrt(A * A - 2 * A * B * C)) / B;
                System.out.println(f(ub) - f(lb));
            }
        }
    }

    private static double f(double y) {
        return -y * y * y / (6 * A) + y * y / (2 * B) - C * y / B;
    }
}
