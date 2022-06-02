package t1305;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/13
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode() {

    }

    /**
     *
     * @param depth 当前要找的是第几层
     * @param nodes
     */
    public void getStr(int depth, List<TreeNode> nodes) {
        int nodeCount = 0;
        //从头到depth-1层的元素数量
        int nums = (int)Math.pow(2,depth-1) - 1;
        //depth-1层元素数量
        int nums1 = (int)Math.pow(2,depth - 2);
        //第depth-1层第一个元素下标值
        int i = nums - nums1;
        //那就不是深度优先遍历而是广度优先遍历了嗷
        TreeNode node;
        for (; i < nums; i++) {
            node = nodes.get(i);
            if (node == null) {
                nodes.add(null);nodes.add(null);
            } else {
                if ((node.left != null && (node.left.left != null || node.left.right != null)) ||
                        (node.right != null && (node.right.left != null || node.right.right != null))) nodeCount++;
                nodes.add(node.left);nodes.add(node.right);
            }
        }
        if (nodeCount > 0) getStr(depth + 1, nodes);
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    /**
     * 层序遍历一棵树的元素并转化为字符串
     * @param node
     * @return
     */
    public static String treeToString(TreeNode node) {
        //每一层遍历并输出
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(node);
        if (node.left != null || node.right != null) { node.getStr(2,nodes);}
        return nodes.toString();
    }

    /**
     * 将数组转化为一棵树，层序遍历
     * @param nums
     * @return
     */
    public static TreeNode convertArrToTree(Integer[] nums) {
        TreeNode[] nodes = new TreeNode[nums.length];
        //获取层数，根据层数，创建每一层元素,创建好的节点放到数组里，方便
        double depth = (Math.log(nums.length + 1) / Math.log(2));
//        if (depth > (int)depth) depth = (int)depth + 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == null) nodes[i] = null;
            else {
                nodes[i] = new TreeNode(nums[i]);
                //获取节点深度
//                double vv = Math.log(i + 1) / Math.log(2);
//                int v = vv > (int)vv ? (int)vv + 1 : (int) vv + 1;
                //获取左右节点
                if (nums.length > (2 * i + 1)) {
                    nodes[i].left = nodes[2 * i + 1];
                }
                if (nums.length > (2 * i + 2)) {
                    nodes[i].right = nodes[2 * i + 2];
                }
            }
        }
        return nodes[0];
    }
}

