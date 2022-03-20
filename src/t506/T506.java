package t506;

import java.util.Arrays;

/**
 * @author 刘勇志
 * @version 1.0
 * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
 * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
 * 名次第 1 的运动员获金牌 "Gold Medal" 。
 * 名次第 2 的运动员获银牌 "Silver Medal" 。
 * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
 * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
 * 示例 1：
 * 输入：score = [5,4,3,2,1]
 * 输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
 * 解释：名次为 [1st, 2nd, 3rd, 4th, 5th] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-ranks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T506 {
    public String[] findRelativeRanks(int[] score) {
        /*
        int n = score.length;
        String[] desc = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; ++i) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        String[] ans = new String[n];
        for (int i = 0; i < n; ++i) {
            if (i >= 3) {
                ans[arr[i][1]] = Integer.toString(i + 1);
            } else {
                ans[arr[i][1]] = desc[i];
            }
        }
        return ans;*/
        int n = score.length;
        String[] res = new String[n];
        int[] num = score.clone();
        Arrays.sort(num);
        for (int i = 0; i < score.length; i++) {
            int a = score.length - Arrays.binarySearch(num, score[i]);
            switch (a) {
                case 1 :
                    res[i] = "Gold Medal"; break;
                case 2 :
                    res[i] = "Silver Medal"; break;
                case 3 :
                    res[i] = "Bronze Medal"; break;
                default :
                    res[i] = Integer.toString(a);;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        T506 t506 = new T506();
        //int[] score = {5, 4, 3, 2, 1};
        int[] score = {10,3,8,9,4};
        System.out.println(Arrays.toString(t506.findRelativeRanks(score)));
    }

}
