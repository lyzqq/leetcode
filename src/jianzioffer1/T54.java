package jianzioffer1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lyz
 * @Date: 2022/4/12 20:51
 * @Version 1.0
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 * <p>
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 */
public class T54 {

    private static int ans = 0, count = 0;
    public static int kthLargest(TreeNode root, int k) {
        helper(root, k);
        return ans;
    }

    private static void helper(TreeNode root, int k) {
        if (root.right != null) helper(root.right, k);
        if (++count == k) {
            ans = root.val;
            return;
        }
        if (root.left != null) helper(root.left, k);
    }
    /*
    public static int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list.get(list.size() - k);
    }

    private static void helper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left != null) {
            helper(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            helper(root.right, list);
        }
    }*/

    public static void main(String[] args) {
        Integer[] nums = {5, 3, 6, 2, 4, null, null, 1};
        TreeNode root = TreeNode.convertArrToTree(nums);
        int k = 3;
        System.out.println(kthLargest(root, k));
    }
}
