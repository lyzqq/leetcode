package nowCoder;

/**
 * @Author Lyz
 * @Date: 2022/4/28 21:55
 * @Version 1.0
 * <p>
 * JZ18 删除链表的节点
 * <p>
 * 描述
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。
 * <p>
 * 1.此题对比原题有改动
 * 2.题目保证链表中节点的值互不相同
 * 3.该题只会输出返回的链表和结果做对比，所以若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 * <p>
 * 数据范围:
 * 0<=链表节点值<=10000
 * 0<=链表长度<=10000
 * <p>
 * <p>
 * 示例1
 * 输入：{2,5,1,9},5
 * 返回值：{2,1,9}
 * 说明：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 2 -> 1 -> 9
 * 示例2
 * 输入：{2,5,1,9},1
 * 返回值：{2,5,9}
 * 说明：
 * 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 2 -> 5 -> 9
 */
public class T18 {
    public static ListNode deleteNode(ListNode head, int val) {
        // write code here
        // 加入一个头节点
        ListNode res = new ListNode(0);
        res.next = head;
        // 前序节点
        ListNode pre = res;
        // 当前节点
        ListNode cur = head;
        // 遍历链表
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        // 返回去掉头结点
        return res.next;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 9};
        ListNode head = new ListNode(nums);
        int val = 5;
        System.out.println(deleteNode(head, val).toString());
    }
}
