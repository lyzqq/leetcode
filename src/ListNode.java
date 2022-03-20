/**
 * @Author Lyz
 * @Date: 2022/2/28 15:21
 * @Version 1.0
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] arr) {
        //对输入的参数进行合法性校验
        if (arr == null) {
            assert false;
            if (arr.length == 0) {
                throw new IllegalArgumentException("arr can not be empty");
            }
        }
        //将数组的首位当作链表的头节点
        this.val = arr[0];
        ListNode cur = this;
        //遍历数组，将元素拼接至链表
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }

    }

    //以当前节点为头节点的链表信息的字符串
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            s.append(cur.val).append("->");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}
