package nowCoder;

/**
 * @Author Lyz
 * @Date: 2022/4/25 19:15
 * @Version 1.0
 * <p>
 * <p>
 * JZ11 旋转数组的最小数字
 * 描述
 * 有一个长度为 n 的非降序数组，比如[1,2,3,4,5]，将它进行旋转，即把一个数组最开始的若干个元素搬到数组的末尾，变成一个旋转数组，比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的。请问，给定这样一个旋转数组，求数组中的最小值。
 * <p>
 * 数据范围：1 \le n \le 100001≤n≤10000，数组中任意元素的值: 0 \le val \le 100000≤val≤10000
 * 要求：空间复杂度：O(1)O(1) ，时间复杂度：O(logn)O(logn)
 * <p>
 * 示例1
 * 输入：[3,4,5,1,2]
 * 返回值： 1
 * 示例2
 * 输入：[3,100,200,3]
 * 返回值：3
 */
public class T10 {
    public static int minNumberInRotateArray(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > array[right]) {
                left = mid + 1;
            } else if (array[mid] == array[right]){
                right--;
            } else {
                right = mid;
            }
        }
        return array[left];
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 1, 2};
        System.out.println(minNumberInRotateArray(array));
    }
}
