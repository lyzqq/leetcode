package jianzioffer1;

/**
 * @Author Lyz
 * @Date: 2022/4/12 21:30
 * @Version 1.0
 */
public class T55Two {

    public static boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private static int height(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /*
    boolean isBalance;
    int height;

    public T55Two(boolean isBalance, int height) {
        this.isBalance = isBalance;
        this.height = height;
    }

    public static boolean isBalanced(TreeNode root) {
        return dfs(root).isBalance;
    }

    private static T55Two dfs(TreeNode root) {
        if (root == null) {
            return new T55Two(true, 0);
        }
        T55Two leftData = dfs(root.left);
        T55Two rightData = dfs(root.right);

        int height = Math.max(leftData.height, rightData.height);
        boolean isBalance = leftData.isBalance && rightData.isBalance && Math.abs(leftData.height - rightData.height) <= 1;
        return new T55Two(isBalance, height);
    }
     */

    public static void main(String[] args) {
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.convertArrToTree(nums);
        System.out.println(isBalanced(root));
    }
}
