package dataStructure.d2queue;

import java.util.LinkedList;

/**
 * @Author Lyz
 * @Date: 2022/4/22 15:29
 * @Version 1.0
 * 双端队列
 */
public class QueueQT<T> {
    private LinkedList<T> list;

    public QueueQT(LinkedList<T> list) {
        this.list = new LinkedList<>();
    }

    // 插入队头
    public void insertLeft(T t) {
        list.addFirst(t);
    }

    // 插入队尾
    public void insertRight(T t) {
        list.addLast(t);
    }

    // 移除对头
    public T removeLeft() {
        T t = list.removeFirst();
        return t;
    }

    // 移除队尾
    public T removeRight() {
        T t = list.removeLast();
        return t;
    }

    // 查看队头
    public T peekLeft() {
        return list.getFirst();
    }

    // 查看队尾
    public T peekRight() {
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
