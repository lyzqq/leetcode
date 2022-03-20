package jianzioffer1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author Lyz
 * @Date: 2022/3/6 19:59
 * @Version 1.0
 * <p>
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * <p>
 * <p>
 * 参考以下这颗二叉搜索树：
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 示例 1：
 * <p>
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: [1,3,2,6,5]
 * 输出: true
 */
public class T33 {

    public boolean verifyPostorder(int[] postorder) {
        // 单调栈使用，，单调递增的单调栈
        Deque<Integer> stack = new LinkedList<>();
        int pervElem = Integer.MAX_VALUE;
        // 逆向遍历，就是反转的先序遍历
        for (int i = postorder.length - 1; i >= 0; --i) {
            // 左子树的元素必须要小于递增栈被peek访问的元素，否则就不是二叉搜索树
            if (postorder[i] > pervElem) {
                return false;
            }
            while (!stack.isEmpty() && postorder[i] < stack.peek()) {
                // 数组元素小于单调栈的元素了，标识左子树走了， 记录下上个根节点
                // 找到这个左子树对应的根节点，之前右子树全部弹出，不再记录，因为
                // 不可能在往根节点的右子树走了
                pervElem = stack.pop();
            }
            // 这个新元素入栈
            stack.push(postorder[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        T33 t33 = new T33();
        int[] postorder = {1, 6, 3, 2, 5};
        System.out.println(t33.verifyPostorder(postorder));
    }
}
