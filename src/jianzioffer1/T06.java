package jianzioffer1;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author Lyz
 * @Date: 2022/3/2 10:00
 * @Version 1.0
 * <p>
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class T06 {

    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop().val;
        }
        return res;
    }

    public static void main(String[] args) {
        T06 t06 = new T06();
        int[] nums = {1, 3, 2};
        ListNode head = new ListNode(nums);
        System.out.println(Arrays.toString(t06.reversePrint(head)));
    }
}
