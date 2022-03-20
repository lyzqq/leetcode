package t119;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘勇志
 * @version 1.0
 * 119. 杨辉三角 II
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 示例 1:
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 * <p>
 * 示例 2:
 * 输入: rowIndex = 0
 * 输出: [1]
 * <p>
 * 示例 3:
 * 输入: rowIndex = 1
 * 输出: [1,1]
 */
public class T119 {

    public List<Integer> getRow(int rowIndex) {

//        List<List<Integer>> C = new ArrayList<List<Integer>>();
//        for (int i = 0; i <= rowIndex; ++i) {
//            List<Integer> row = new ArrayList<Integer>();
//            for (int j = 0; j <= i; ++j) {
//                if (j == 0 || j == i) {
//                    row.add(1);
//                } else {
//                    row.add(C.get(i - 1).get(j - 1) + C.get(i - 1).get(j));
//                }
//            }
//            C.add(row);
//        }
//        return C.get(rowIndex);

//        List<Integer> pre = new ArrayList<Integer>();
//        for (int i = 0; i <= rowIndex; ++i) {
//            List<Integer> cur = new ArrayList<Integer>();
//            for (int j = 0; j <= i; ++j) {
//                if (j == 0 || j == i) {
//                    cur.add(1);
//                } else {
//                    cur.add(pre.get(j - 1) + pre.get(j));
//                }
//            }
//            pre = cur;
//        }
//        return pre;

        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            list.add(0);
            for (int j = i; j > 0; --j) {
                list.set(j, list.get(j) + list.get(j - 1));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        T119 t119 = new T119();
        int rowIndex = 3;
        System.out.println(t119.getRow(rowIndex));
    }
}
