package jianzioffer1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Lyz
 * @Date: 2022/4/12 21:13
 * @Version 1.0
 */
public class T55One {

    public static int maxDepth(TreeNode root) {
        /**
         * 递归
         */
        // return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right))  + 1;
        /**
         * 层序遍历
         */
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){
            {
                add(root);
            }
        };
        int depth = 0;
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.convertArrToTree(nums);
        System.out.println(maxDepth(root));
    }
}
