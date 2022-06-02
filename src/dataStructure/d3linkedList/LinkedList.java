package dataStructure.d3linkedList;

/**
 * @Author Lyz
 * @Date: 2022/4/23 0:02
 * @Version 1.0
 * // 模拟链表
 */
public class LinkedList<T> {
    private class Node{
        T data;
        Node next;
    }

    private Node head;
    private Node tail;
    private int size;

    public int size() {
        return this.size;
    }

    // 获取头部元素
    public T getFirst() throws Exception {
        if (this.size == 0) {
            throw new Exception("LL is Empty.");
        }
        return this.head.data;
    }

    // 获取最末尾元素
    public T getLast() throws Exception {
        if (this.size == 0) {
            throw new Exception("LL is Empty.");
        }
        return this.tail.data;
    }

    // 获取索引处所在元素
    public T getAt(int idx) throws Exception {
        if (this.size == 0) {
            throw new Exception("LL is Empty.");
        }
        if (idx < 0 || idx >= this.size) {
            throw new Exception("Invalid Index");
        }
        Node temp = this.head;
        for (int i = 1; i <= idx; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    // 获取索引处的node
    public Node getNodeAt(int idx) throws Exception {
        if (this.size == 0) {
            throw new Exception("LL is Empty.");
        }
        if (idx < 0 || idx >= this.size) {
            throw new Exception("Invalid Index");
        }
        Node temp = this.head;
        for (int i = 1; i <= idx; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // 末尾添加
    public void addLast(T item) {
        // create
        Node nn = new Node();
        nn.data = item;
        nn.next = null;
        // attach
        if (this.size > 0) {
            this.tail.next = nn;
        }
        // dm update
        if (this.size == 0) {
            this.head = nn;
            this.tail = nn;
            this.size++;
        } else {
            this.tail = nn;
            this.size++;
        }
    }

    // 首部添加
    public void addFirst(T item) {
        // create
        Node nn = new Node();
        nn.data = item;
        nn.next = null;
        // attach
        nn.next = this.head;

        // dm update
        if (this.size == 0) {
            this.head = nn;
            this.tail = nn;
            this.size++;
        } else {
            this.head = nn;
            this.size++;
        }
    }

    // 添加元素到索引位置
    public void addAt(T item, int idx) throws Exception {
        if (idx < 0 || idx > this.size) {
            throw new Exception("Invalid Index");
        }
        if (idx == 0) {
            addFirst(item);
        } else if (idx == this.size) {
            addLast(item);
        } else {
            // create
            Node nn = new Node();
            nn.data = item;
            nn.next = null;
            // attach
            Node nm1 = getNodeAt(idx - 1);
            Node np1 = nm1.next;
            nm1.next = nn;
            nn.next = np1;
            // dm
            this.size++;
        }
    }

    // 移除首部元素
    public T removeFirst() throws Exception {
        if (this.size == 0) {
            throw new Exception("LL is Empty.");
        }

        Node temp = this.head;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
            this.size = 0;
        } else {
            this.head = this.head.next;
            this.size--;
        }
        return temp.data;
    }

    // 移除尾部元素
    public T removeLast() throws Exception {
        if (this.size == 0) {
            throw new Exception("LL is Empty.");
        }
        Node temp = this.tail;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
            this.size = 0;
        } else {
            Node sm2 = getNodeAt(this.size - 2);
            sm2.next = null;
            this.tail = sm2;
            this.size--;
        }
        return temp.data;
    }

    // 移除指定索引位置的元素
    public T removeAt(int idx) throws Exception {
        if (this.size == 0) {
            throw new Exception("LL is Empty.");
        }
        if (idx < 0 || idx > this.size) {
            throw new Exception("Invalid Index");
        }
        if (idx == 0) {
            return removeFirst();
        } else if (idx == this.size - 1) {
            return removeLast();
        } else {
            Node nm1 = getNodeAt(idx - 1);
            Node n = nm1.next;
            Node np1 = n.next;
            nm1.next = np1;
            this.size--;
            return n.data;
        }
    }

    // 显示
    public void display() {
        System.out.println("--------");
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(".");
    }

    public static void main(String[] args) throws Exception {
        LinkedList<Integer> list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.display();
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.getNodeAt(3));
        System.out.println(list.removeFirst());
        System.out.println(list.removeLast());
        list.display();
        list.removeAt(2);
        list.addAt(300,2);
        list.display();
    }
}
