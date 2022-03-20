package t19;


import common.ListNode;

/**
 * @Author Lyz
 * @Date: 2022/2/28 15:11
 * @Version 1.0
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */

public class T19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
//        if(head == null || head.next == null) return null;
//        ListNode fast = head, slow = head;
//        for(int i = 0; i < n; i++) {
//            fast = fast.next;
//        }
//        if(fast != null) {
//            return head.next;
//        }
//        while (fast.next != null) {
//            fast = fast.next;
//            slow = slow.next;
//        }
//        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        T19 t19 = new T19();
        int n = 2;
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        System.out.println(t19.removeNthFromEnd(head, n));
    }
}
