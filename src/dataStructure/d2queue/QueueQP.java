package dataStructure.d2queue;

import java.util.Arrays;

/**
 * @Author Lyz
 * @Date: 2022/4/22 15:42
 * @Version 1.0
 * 优先级队列
 */
public class QueueQP<T> {
    private int max;
    private T[] arr;
    private int items;

    public QueueQP(int size) {
        this.max = size;
        arr = (T[]) new Object[max];
        items = 0;
    }

    // 插入队尾
    public void insert(T t) {
        if (ifFull()) {
            max = max * 3 / 2 + 1;
            arr = Arrays.copyOf(arr, max);
        }
        int j;
        if (items == 0) {
            arr[items++] = t;
        } else {
            for (j = items - 1; j >= 0; j--) {
                if (t.toString().compareTo(arr[j].toString()) > 0 ) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = t;
            items++;
        }
        System.out.println(Arrays.toString(arr));
    }

    // 移除队头,优先级小的
    public T remove() {
        T t = arr[items - 1];
        arr[items-- - 1] = null;
        return t;
    }

    // 查看队尾，优先级最低的
    public T peekMin() {
        return arr[items - 1];
    }

    public boolean isEmpty() {
        return items == 0;
    }

    public boolean ifFull() {
        return items == max;
    }

    public int size() {
        return items;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        QueueQP<Integer> queueQP = new QueueQP(3);
        queueQP.insert(1);
        queueQP.insert(2);
        queueQP.insert(3);
        int remove = queueQP.remove();
        System.out.println("remove: " + remove);
        System.out.println(queueQP.toString());
        Integer min = queueQP.peekMin();
        System.out.println(min);
    }

}
