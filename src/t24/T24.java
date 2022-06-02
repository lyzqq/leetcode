package t24;

/**
 * @Author Lyz
 * @Date: 2022/4/18 19:31
 * @Version 1.0
 * 24. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 */
public class T24 {

    public static ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;

        /*
        if (head == null || head.next == null) {
            return head;
        }
        ListNode one = head;
        ListNode two = one.next;
        ListNode three = two.next;

        two.next = one;
        one.next = swapPairs(three);
        return two;*/
        /*
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;*/
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ListNode head = new ListNode(nums);
        System.out.println(swapPairs(head));
    }
}
