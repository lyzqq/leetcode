package jianzioffer1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lyz
 * @Date: 2022/3/5 18:40
 * @Version 1.0
 * <p>
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 * 例如:
 * 给定二叉树[3,9,20,null,null,15,7],
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
 *   [9,20],
 *   [15,7]
 * ]
 *
 */
public class T32Two {

    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        ad(root, 0);
        return lists;
    }

    private void ad(TreeNode root, int k) {
        if (root != null) {
            if (lists.size() <= k) lists.add(new ArrayList<>());
            lists.get(k).add(root.val);
            ad(root.left, k + 1);
            ad(root.right, k + 1);
        }
    }


    public static void main(String[] args) {
        T32Two t32Two = new T32Two();
        Integer[] nums = {3, 9, 20, 15, 7};
        TreeNode root = TreeNode.convertArrToTree(nums);
        System.out.println(t32Two.levelOrder(root));
    }
}
