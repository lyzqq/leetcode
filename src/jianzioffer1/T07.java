package jianzioffer1;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Lyz
 * @Date: 2022/3/2 10:26
 * @Version 1.0
 * <p>
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * <p>
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * 示例 1:
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 示例 2:
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 */
public class T07 {

    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        int inorder_root = indexMap.get(preorder[preorder_left]);

        TreeNode root = new TreeNode(preorder[preorder_left]);

        int size_left_subtree = inorder_root - inorder_left;
        root.left = myBuildTree(preorder, inorder,
                preorder_left + 1,
                preorder_left + size_left_subtree,
                inorder_left,
                inorder_root - 1);
        root.right = myBuildTree(preorder, inorder,
                preorder_left + size_left_subtree + 1,
                preorder_right,
                inorder_root + 1,
                inorder_right);
        return root;
    }


    public static void main(String[] args) {
        T07 t07 = new T07();
//        int[] preorder = {3, 9, 20, 15, 7};
        int[] preorder = {1, 2, 4, 3, 7};
//        int[] inorder = {9, 3, 15, 20, 7};
        int[] inorder = {4, 2, 1, 3, 7};
        System.out.println(t07.buildTree(preorder, inorder));
        System.out.println(TreeNode.treeToString(t07.buildTree(preorder, inorder)));
    }
}
