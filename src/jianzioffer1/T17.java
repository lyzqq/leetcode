package jianzioffer1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Lyz
 * @Date: 2022/3/4 11:43
 * @Version 1.0
 * <p>
 * 剑指 Offer 17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 */
public class T17 {

    public int[] printNumbers(int n) {

        int[] ans = new int[(int)(Math.pow(10, n)) - 1];
        Queue<String> q = new LinkedList<>();
        //将1~9加入队列
        for (int i = 1; i <= 9; i++){
            q.offer(String.valueOf(i));
        }
        int length = 1;
        int index = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                //将队列中的元素依次取出并加入答案
                String str = q.poll();
                ans[index++] = Integer.parseInt(str);
                //若当前元素长度不够n，则在末尾补充0~9，继续加入队列
                if (str.length() < n){
                    for (int j = 0; j <= 9; j++){
                        q.offer(str + j);
                    }
                }
            }
        }
        return ans;

        /**
         * 不考虑大数
        int m = (int)Math.pow(10, n);
        int[] nums = new int[m - 1];
        for (int i = 0; i < m - 1; i++) {
            nums[i] = i + 1;
        }
        return nums;
         */
    }

    public static void main(String[] args) {
        T17 t17 = new T17();
        int i = 1;
        System.out.println(Arrays.toString(t17.printNumbers(i)));
    }
}
