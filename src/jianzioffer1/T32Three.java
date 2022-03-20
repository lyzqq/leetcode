package jianzioffer1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lyz
 * @Date: 2022/3/5 18:52
 * @Version 1.0
 *
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 *
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class T32Three {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        ad(root,0);
        return lists;
    }

    private void ad(TreeNode root, int k) {
        if (root != null) {
            if (lists.size() <= k) lists.add(new ArrayList<>());
            if (k % 2 == 0) {
                lists.get(k).add(root.val);
            } else {
                lists.get(k).add(0,root.val);
            }
            ad(root.left, k + 1);
            ad(root.right, k + 1);
        }
    }

    public static void main(String[] args) {
        T32Three t32Three = new T32Three();
//        Integer[] nums = {3, 9, 20, 15, 7};
        Integer[] nums = {1, 2, 3, 4, 5, 8 ,9};
        TreeNode root = TreeNode.convertArrToTree(nums);
        System.out.println(t32Three.levelOrder(root));
    }
}
