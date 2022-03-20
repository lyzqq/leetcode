package jianzioffer1;

/**
 * @Author Lyz
 * @Date: 2022/3/5 16:14
 * @Version 1.0
 * <p>
 * 剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 */
public class T28 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) return false;
        return root1.val == root2.val && helper(root1.left, root2.right)
                && helper(root1.right, root2.left);
    }

    public static void main(String[] args) {
        T28 t28 = new T28();
        Integer[] nums = {1, 2, 2, 3, 4, 4, 3};
        TreeNode root = TreeNode.convertArrToTree(nums);
        System.out.println(t28.isSymmetric(root));
    }
}
