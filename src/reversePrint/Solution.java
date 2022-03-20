package reversePrint;

import java.util.LinkedList;

/**
 * @author 刘勇志
 * @version 1.0
 * 从头到尾打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    //   ArrayList<Integer> tmp = new ArrayList<Integer>();
    public static int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = stack.removeLast();
        return res;
    }

    //        recur(head);
//        int[] res = new int[tmp.size()];
//        for (int i = 0; i < res.length; i++) {
//            res[i] = tmp.get(i);
//        }
//        return res;
//    }
//
//    void recur(ListNode head) {
//        if(head == null) return;
//        recur(head.next);
//        tmp.add(head.val);
//    }
    public static void main(String[] args) {
        // ListNode head1 = new LinkedList<Integer>();
        // head1.add(1);
        // head1.add(3);
        // head1.add(2);
        // System.out.println(reversePrint(head1));
    }
}
