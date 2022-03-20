package jianzioffer1;

/**
 * @Author Lyz
 * @Date: 2022/3/5 14:40
 * @Version 1.0
 * <p>
 * 剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 镜像输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 */
public class T27 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        T27 t27 = new T27();
        Integer[] nums = {4, 2, 7, 1, 3, 6, 9};
        TreeNode root = TreeNode.convertArrToTree(nums);
        System.out.println(t27.mirrorTree(root));
        System.out.println(TreeNode.treeToString(t27.mirrorTree(root)));
    }
}
