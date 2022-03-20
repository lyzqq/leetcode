package t1588;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 1588. 所有奇数长度子数组的和
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 * 子数组 定义为原数组中的一个连续子序列。
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 * 示例 1：
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * <p>
 * 示例 2：
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 * <p>
 * 示例 3：
 * 输入：arr = [10,11,12]
 * 输出：66
 */
public class T1588 {
    public int sumOddLengthSubarrays(int[] arr) {
//        int sum = 0;
//        int n = arr.length;
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j += 2) {
//                for (int k = i; k <= j; k++) {
//                    sum += arr[k];
//                }
//            }
//        }
//        return sum;
        int sum = 0;
        int n = arr.length;
        int[] newArr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            newArr[i + 1] = newArr[i] + arr[i];
        }
        for (int left = 0; left < n; left++) {
            for (int length = 1; left + length <= n; length += 2) {
                int right = left + length - 1;
                sum += newArr[right + 1] - newArr[left];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        T1588 t1588 = new T1588();
        int[] arr = {1, 4, 2, 5, 3};
        System.out.println(t1588.sumOddLengthSubarrays(arr));
    }
}
