package dataStructure.d2queue;

import java.util.Arrays;

/**
 * @Author Lyz
 * @Date: 2022/4/22 10:52
 * @Version 1.0
 */
public class Queue<T> {

    private int max;
    // int size;
    private T[] arr;
    private int front; // 队头指针 只是取出顶的位置
    private int rear; // 队尾指针 指示插入的位置
    private int items; // 实际数据项个数

    public Queue(int size) {
        max = size;
        arr = (T[]) new Object[max];
        front = 0;
        rear = -1;
        items = 0;
    }

    // 插入队尾
    public void insert(T t) {
        if (isFull()) {
//            size = size * 3 / 2 + 1;
            max = max * 3 / 2 + 1;
            arr = Arrays.copyOf(arr, max);
        }
//        if (rear == max - 1) { // 已经到实际队尾，从头开始
//            rear = -1;
//        }
        arr[++rear] = t;
        items++;
    }

    // 移除队头
    public T remove() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,无法出队列");
        }
        T temp = arr[front];
        arr[front++] = null;
//        if (front == max) {
//            // 队列到尾了，从头开始
//            front = 0;
//        }
        items--;
        return temp;
    }

    // 查看对头
    public T peek() {
        return arr[front];
    }

    boolean isEmpty() {
        return this.items == 0;
    }

    boolean isFull() {
        return this.items == arr.length;
    }

    int size() {
        return items;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
