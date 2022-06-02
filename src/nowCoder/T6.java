package nowCoder;

import java.util.ArrayList;

/**
 * @Author Lyz
 * @Date: 2022/4/25 16:10
 * @Version 1.0
 * JZ6 从尾到头打印链表
 * 输入一个链表的头节点，按链表从尾到头的顺序返回每个节点的值（用数组返回）。
 * 如输入{1,2,3}的链表如下图:
 * 返回一个数组为[3,2,1]
 * 0 <= 链表长度 <= 10000
 *
 * {1,2,3}
 * [3,2,1]
 */
public class T6 {

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        ArrayList<Integer> tem = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        while (listNode != null) {
            res.add(0,listNode.val);
            listNode = listNode.next;
        }
//        for (int i = tem.size() - 1; i >= 0; i--) {
//            res.add(tem.get(i));
//        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ListNode listNode = new ListNode(nums);
        System.out.println(printListFromTailToHead(listNode));
    }
}
