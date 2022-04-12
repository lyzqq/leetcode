package sort;

import java.util.Arrays;

/**
 * @Author Lyz
 * @Date: 2022/3/28 15:58
 * @Version 1.0
 * 插入排列
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = {5, 3, 4, 6, 2, 1};
        System.out.println(Arrays.toString(insertSort(array)));
    }

    private static int[] insertSort(int[] array) {
        int len = array.length;
        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个
        for (int i = 1; i < len; i++) {

            // 记录要插入的数据
            int tmp = array[i];

            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }

            // 存在比其小的数，插入
            if (j != i) {
                array[j] = tmp;
            }
        }
        return array;
    }
}
