package t440;


/**
 * @Author Lyz
 * @Date: 2022/3/23 10:10
 * @Version 1.0
 * <p>
 * 440. 字典序的第K小数字
 * 给定整数 n 和 k，返回  [1, n] 中字典序第 k 小的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 13, k = 2
 * 输出: 10
 * 解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 * 示例 2:
 * <p>
 * 输入: n = 1, k = 1
 * 输出: 1
 */
public class T440 {

    public int findKthNumber(int n, int k) {
        int cnt = 0;    // 已经经过的元素个数，开始一个元素都没有经过，所以个数为0
        int num = 1;    // 第一个元素(经过i个元素，当前num是第 i + 1元素)

        // 要找到第k个元素，需要经过k - 1个元素
        while(true) {
            if (cnt == k - 1) {
                // 经过了k - 1个元素，找到了第k个元素
                break;
            }
            int temp = count(num, n);    // 以num为根，以n为最大值的十叉数的元素总个数
            if (cnt + temp >= k) {
                // 以num为跟的十叉数内有第k个元素
                num *= 10;
                cnt++;
            } else if (cnt + temp < k) {
                // 以num为跟的十叉数内没有第k个元素
                num++;
                cnt += temp;
            }
        }
        return num;
    }

    /**
     * 以当前数字为根的十叉树的元素总个数 (包括当前数字)
     * @param num 当前数字 (需要先 cast 成 long, 因为 num*10 可能导致 int 溢出
     * @param n 数字的最大值
     * @return
     */
    private int count(long num, int n) {
        int cnt = 0; // 元素总个数
        int width = 1; // 当前层数的宽度，第一层只有num一个元素，所以第一层宽度为1
        while (true) {
            if (num + width - 1 <= n) {
                // n 的值大于等于当前层的最大值，说明当前层数的个数可以全部添加
                cnt += width;
                num *= 10;
                width *= 10;
            } else {
                // n 的值小于当前层的最大值，只能添加部分个数或者不添加，并跳出循环
                if (n - num >= 0) {
                    cnt += n - num + 1;
                }
                break;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        T440 t440 = new T440();
        int n = 13, k = 2;
        System.out.println(t440.findKthNumber(n, k));
    }
}
