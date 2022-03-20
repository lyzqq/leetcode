package t739;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 刘勇志
 * @version 1.0
 * 739. 每日温度
 * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 */
public class T739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        res[temperatures.length - 1] = 0;
        for (int i = temperatures.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < temperatures.length; j += res[j]) {
                if (temperatures[i] < temperatures[j]) {
                    res[i] = j - i;
                    break;
                } else if (res[j] == 0) {
                    res[i] = 0;
                    break;
                }
            }
        }
        return res;
        /** 内存消耗大
         int length = temperatures.length;
         int[] ans = new int[length];
         Deque<Integer> stack = new LinkedList<Integer>();
         for (int i = 0; i < length; i++) {
         int temperature = temperatures[i];
         while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
         int prevIndex = stack.pop();
         ans[prevIndex] = i - prevIndex;
         }
         stack.push(i);
         }
         return ans;*/
        //  可行，复杂度高
        //int n = temperatures.length;
        //int[] ans = new int[n];
        //ans[n - 1] = 0;
        //for (int i = n - 1; i >= 0; i--) {
        //    int end = i + 1;
        //    while (end <= n - 1) {
        //        if (temperatures[i] < temperatures[end]) {
        //            ans[i] = end - i;
        //            break;
        //        } else end++;
        //    }
        //    if (end > n - 1) {
        //        ans[i] = 0;
        //    }
        //}
        //return ans;
    }

    public static void main(String[] args) {
        T739 t739 = new T739();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(t739.dailyTemperatures(temperatures)));
    }
}
