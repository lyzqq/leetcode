package jianzioffer1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author Lyz
 * @Date: 2022/3/2 12:09
 * @Version 1.0
 */
public class T09 {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public T09() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                return -1;
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        } else {
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        T09 t09 = new T09();
    }
}
