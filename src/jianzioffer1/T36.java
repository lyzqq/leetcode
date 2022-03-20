package jianzioffer1;

/**
 * @Author Lyz
 * @Date: 2022/3/18 12:05
 * @Version 1.0
 */
public class T36 {

    // 1.中序，递归
    TreeNode pre, head;

    public TreeNode treeToDoublyList(TreeNode root) {
        // 边界值
        if (root == null) return null;
        dfs(root);

        // 题目要求头尾连接
        head.left = pre;
        pre.right = head;
        // 返回头结点
        return head;
    }

    void dfs(TreeNode cur) {
        // 递归循环条件
        if (cur == null) return;
        dfs(cur.left);
        // 如果pre为空，就说明是第一个节点，头结点，然后用head保存头结点，用于之后的返回
        if (pre == null) head = cur;
            // 如果不为空，那就说明是中间的节点。并且pre保存的是上一个节点
            // 让上一个节点的右指针指向当前节点
        else if (pre != null) pre.right = cur;
        // 再让当前节点的左指针指向父节点，也就连成了双向链表。
        cur.left = pre;
        // 保存当前节点，用于下层传递创建
        pre = cur;
        dfs(cur.right);
    }

    public static void main(String[] args) {
        T36 t36 = new T36();
        Integer[] nums = {4, 2, 5, 1, 3};
        TreeNode root = TreeNode.convertArrToTree(nums);
        System.out.println(TreeNode.treeToString(t36.treeToDoublyList(root)));
    }
}
