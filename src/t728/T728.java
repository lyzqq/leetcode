package t728;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lyz
 * @Date: 2022/3/31 19:28
 * @Version 1.0
 * <p>
 * 728. 自除数
 * 自除数 是指可以被它包含的每一位数整除的数。
 * <p>
 * 例如，128 是一个 自除数 ，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 自除数 不允许包含 0 。
 * <p>
 * 给定两个整数 left 和 right ，返回一个列表，列表的元素是范围 [left, right] 内所有的 自除数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：left = 1, right = 22
 * 输出：[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * 示例 2:
 * <p>
 * 输入：left = 47, right = 85
 * 输出：[48,55,66,77]
 */
public class T728 {

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        while (left <= right) {
            if (isDN(left)) {
                list.add(left);
            }
            left++;
        }
        return list;
    }

    private static boolean isDN(int left) {
        int tem = left;
        boolean flag = true;
        while (tem != 0) {
            int temp = tem % 10;
            if (temp == 0) {
                return false;
            }
            if (left % temp == 0) {
                tem /= 10;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int left = 1;
        int right = 22;
        System.out.println(selfDividingNumbers(left, right));
    }
}
