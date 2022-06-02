package dataStructure.d2queue;

import java.util.LinkedList;

/**
 * @Author Lyz
 * @Date: 2022/4/22 11:26
 * @Version 1.0
 */
public class Demo {
    public static void main(String[] args) {
//        java.util.Queue queue1 = new LinkedList();
//        System.out.println(queue1);
        Queue<Integer> queue = new Queue<>(3);
        for (int i = 0; i < 5; i++) {
            queue.insert(i);
            System.out.println("size" + queue.size());
            System.out.println(queue.toString());
        }
        for (int i = 0; i < 5; i++) {
            int peek = queue.peek();
            System.out.println("peek:" + peek);
            System.out.println("size:" + queue.size());
            System.out.println(queue.toString());
        }
        for (int i = 0; i < 5; i++) {
            int remove = queue.remove();
            System.out.println("remove:" + remove);
            System.out.println("size:" + queue.size());
            System.out.println(queue.toString());
        }
    }
}
