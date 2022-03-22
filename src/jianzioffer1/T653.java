package jianzioffer1;

import java.util.HashSet;

/**
 * @Author Lyz
 * @Date: 2022/3/21 9:04
 * @Version 1.0
 * <p>
 * 653. 两数之和 IV - 输入 BST
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], k = 9
 * 输出: true
 * 示例 2：
 * <p>
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], k = 28
 * 输出: false
 */
public class T653 {

    HashSet<Integer> set = new HashSet<Integer>();

    public boolean findTarget(TreeNode root, int k) {
        return check(root, k);
    }

    private boolean check(TreeNode root, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return check(root.left, k) || check(root.right, k);
    }

    public static void main(String[] args) {
        T653 t653 = new T653();
        Integer[] nums = {5, 3, 6, 2, 4, null, 7};
        TreeNode root = TreeNode.convertArrToTree(nums);
        System.out.println(t653.findTarget(root, 9));
    }
}
