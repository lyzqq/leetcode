package t678;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 678. 有效的括号字符串
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。
 * 有效字符串具有如下规则：
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * 示例 1:
 * 输入: "()"
 * 输出: True
 * 示例 2:
 * 输入: "(*)"
 * 输出: True
 * 示例 3:
 * 输入: "(*))"
 * 输出: True
 */
public class T678 {
    public boolean checkValidString(String s) {
        int minCount = 0, maxCount = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                minCount++;
                maxCount++;
            } else if (c == ')') {
                minCount = Math.max(minCount - 1, 0);
                maxCount--;
                if (maxCount < 0) {
                    return false;
                }
            } else {
                minCount = Math.max(minCount - 1, 0);
                maxCount++;
            }
        }
        return minCount == 0;
        /*  不行
        int n = s.length();
        int num1 = 0, num2 = 0, num3 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                num1++;
            } else if (s.charAt(i) == '(') {
                num2++;
            } else if (s.charAt(i) == ')') {
                num2--;
            } else {
                continue;
            }
            if (Math.abs(num2) < num1 || num2 == 0) {
                num1 = 0;
                num2 = 0;
            }
        }
        if (num1 < Math.abs(num2)) {
            return false;
        }
        return true;*/
    }

    public static void main(String[] args) {
        T678 t678 = new T678();
//        String s = "(*))";
        String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
//        String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*))))";
//        String s = "(((((*)))**";
        System.out.println(t678.checkValidString(s));
    }
}
