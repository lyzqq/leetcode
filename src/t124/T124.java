package t124;


/**
 * @Author Lyz
 * @Date: 2022/4/10 14:13
 * @Version 1.0
 */
public class T124 {

    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
    // 函数功能：返回当前节点能为父亲提供的贡献，需要结合上面的图来看
    private static int dfs(TreeNode root) {
        // 如果当前节点为叶子节点，那么对父亲贡献为 0
        if (root == null) return 0;
        // 如果不是叶子节点，计算当前节点的左右孩子对自身的贡献left和right
        int left = dfs(root.left);
        int right = dfs(root.right);
        // 更新最大值，就是当前节点的val 加上左右节点的贡献。
        maxSum = Math.max(maxSum, root.val + left+ right);
        // 计算当前节点能为父亲提供的最大贡献，必须是把 val 加上！
        int max = Math.max(root.val + left, root.val + right);
        // 如果贡献小于0的话，直接返回0
        return Math.max(max, 0);
    }

    public static void main(String[] args) {

        Integer[] nums = {-10, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.convertArrToTree(nums);
        System.out.println(maxPathSum(root));
    }
}
