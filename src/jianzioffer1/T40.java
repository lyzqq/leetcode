package jianzioffer1;

import java.util.Arrays;

/**
 * @Author Lyz
 * @Date: 2022/3/19 17:55
 * @Version 1.0
 * <p>
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * <p>
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 */
public class T40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下表为k - 1的数。
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] arr, int lo, int hi, int k) {
        // 每次快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数i
        int j = partition(arr, lo, hi);
        if (j == k) {
            return Arrays.copyOf(arr, j + 1);
        }
        // 否则根据下标j与k的大小来决定继续切分左段还是右段。
        return j > k ? quickSearch(arr, lo, j - 1, k) : quickSearch(arr, j + 1, hi, k);
    }

    // 快排切分， 返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边
    private int partition(int[] arr, int lo, int hi) {
        int v = arr[lo];
        int i = lo, j = hi + i;
        while (true) {
            while (++i <= hi && arr[i] < v);
            while (--j >= lo && arr[j] > v);
            if (i > j) break;
            int t = arr[j];
            arr[j] = arr[i];
            arr[i] = t;
        }
        arr[lo] = arr[j];
        arr[j] = v;
        return j;
    }

    public static void main(String[] args) {
        T40 t40 = new T40();
        int[] arr = {0, 1, 2, 1};
        int k = 2;
        System.out.println(Arrays.toString(t40.getLeastNumbers(arr, k)));
    }
}
