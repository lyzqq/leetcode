package t415;

/**
 * @author 刘勇志
 * @version 1.0
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * 示例 1：
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 */
public class T415 {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--;
            j--;
        }
        if (carry == 1) res.append(1);
        return res.reverse().toString();
        /*
        索引溢出
        int num3 = 0, num4 = 0;
        for (int i = 0; i < num1.length(); i++) {
            num3 = (int)num1.charAt(i) - '0' + num3 * 10;
        }
        for (int i = 0; i < num2.length(); i++) {
            num4 = (int)num2.charAt(i) - '0' + num4 * 10;
        }
        return num3 + num4 + "";*/
    }

    public static void main(String[] args) {
        T415 t415 = new T415();
        String num1 = "11";
        String num2 = "123";
        System.out.println(t415.addStrings(num1, num2));
    }
}
