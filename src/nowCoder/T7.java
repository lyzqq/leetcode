package nowCoder;

import java.util.Arrays;

/**
 * @Author Lyz
 * @Date: 2022/4/25 16:18
 * @Version 1.0
 * <p>
 * JZ7 重建二叉树
 * 描述
 * 给定节点数为 n 的二叉树的前序遍历和中序遍历结果，请重建出该二叉树并返回它的头结点。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建出如下图所示。
 * 提示:
 * 1.vin.length == pre.length
 * 2.pre 和 vin 均无重复元素
 * 3.vin出现的元素均出现在 pre里
 * 4.只需要返回根结点，系统会自动输出整颗树做答案对比
 * 数据范围：n \le 2000n≤2000，节点的值 -10000 \le val \le 10000−10000≤val≤10000
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 * 示例1
 * 输入：
 * [1,2,4,7,3,5,6,8],[4,7,2,1,5,3,8,6]
 * 复制
 * 返回值：{1,2,3,4,#,5,6,#,7,#,#,8}
 * 说明： 返回根节点，系统会输出整颗二叉树对比结果，重建结果如题面图示
 */
public class T7 {
    public static TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        if (pre.length == 0 || vin.length == 0) {
            return null;
        }
        TreeNode res = new TreeNode(pre[0]);
        for (int i = 0; i < vin.length; i++) {
            if (vin[i] == pre[0]) {
                // 左子树，注意 copyOfRange 函数，左闭右开
                res.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(vin, 0, i));
                // 右子树，注意 copyOfRange 函数，左闭右开
                res.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(vin, i + 1, vin.length));
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] vin = {4, 7, 2, 1, 5, 3, 8, 6};
        System.out.println(reConstructBinaryTree(pre, vin));
    }
}
