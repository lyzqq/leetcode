package t838;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author Lyz
 * @Date: 2022/2/23 14:30
 * @Version 1.0
 *
 * 838. 推多米诺
 * n 张多米诺骨牌排成一行，将每张多米诺骨牌垂直竖立。在开始时，同时把一些多米诺骨牌向左或向右推。
 *
 * 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
 *
 * 如果一张垂直竖立的多米诺骨牌的两侧同时有多米诺骨牌倒下时，由于受力平衡， 该骨牌仍然保持不变。
 *
 * 就这个问题而言，我们会认为一张正在倒下的多米诺骨牌不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力。
 *
 * 给你一个字符串 dominoes 表示这一行多米诺骨牌的初始状态，其中：
 *
 * dominoes[i] = 'L'，表示第 i 张多米诺骨牌被推向左侧，
 * dominoes[i] = 'R'，表示第 i 张多米诺骨牌被推向右侧，
 * dominoes[i] = '.'，表示没有推动第 i 张多米诺骨牌。
 * 返回表示最终状态的字符串。
 *
 *
 * 示例 1：
 * 输入：dominoes = "RR.L"
 * 输出："RR.L"
 * 解释：第一张多米诺骨牌没有给第二张施加额外的力。
 *
 * 示例 2：
 * 输入：dominoes = ".L.R...LR..L.."
 * 输出："LL.RR.LLRRLL.."
 */
public class T838 {

    /**
     *
     * @param dominoes
     * @return
     *  思路：
     *      首先，边界条件不好判断，直接左边加'L',右边加上'R',不会对结果造成影响，最后记得去掉
     *      然后，总共四种情况  L.....L => LLLLLLL
     *                       L.....R => L.....R
     *                       R.....L => RRR.LLL
     *                       R.....R => RRRRRRR
     *      举例：.L.R...LR..L..
     *      首尾添加LR=> L.L.R...LR..L..R
     *      一番操作=> LLL.RR.LLRRLL..R
     *      首尾减去LR=>  LL.RR.LLRRLL..
     */

    public String pushDominoes(String dominoes) {
        dominoes = 'L' + dominoes + 'R';
        char[] arr = dominoes.toCharArray();
        // 最小长度为3，不用担心越界
        int left = 0, right = 1;
        while (right < arr.length) {
            while (arr[right] == '.') {
                right++;
            }
            if (arr[left] == arr[right]) {
                // 这两种情况
                // L.....L => LLLLLLL
                // R.....R => RRRRRRR
                update(arr, left, right);
            } else {
                // 这种情况 R.....L =>RRR.LLL
                if (arr[left] == 'R') {
                    update(arr, left, right);
                    if ((right - left + 1) % 2 == 1) {
                        // 中间可能要置为'.'
                        arr[left + right >> 1] = '.';
                    }
                }
                // 这种情况 L...R => L...R
                // 什么都不用做
            }
            // 进入下一个
            left = right;
            right = right + 1;
        }
        return new String(arr, 1, arr.length - 2);
    }

    public void update(char[] arr, int L, int R) {
        int left = L, right = R;
        while (left <= right) {
            arr[left] = arr[L];
            arr[right] = arr[R];
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        T838 t838 = new T838();
        String dominoes = "RR.L";
        System.out.println(t838.pushDominoes(dominoes));
    }
}
