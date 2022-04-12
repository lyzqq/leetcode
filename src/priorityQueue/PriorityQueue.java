package priorityQueue;

import static sun.java2d.Disposer.getQueue;

/**
 * @Author Lyz
 * @Date: 2022/4/1 12:10
 * @Version 1.0
 */
public class PriorityQueue {

    public static void main(String[] args) {
        PriorQueue pq = new PriorQueue(4);
        pq.push(2);
        pq.push(1);
        pq.push(5);
        pq.push(3);
        pq.push(4);
        pq.pop();
        pq.pop();
        pq.push(1);
        pq.pop();
        pq.push(6);
        pq.pop();
        pq.pop();
    }
}

class PriorQueue{
    private int size, countElem = 0;
    private int[] arr;

    public PriorQueue(int size) {
        this.size = size;
        this.arr = new int[size];
    }

    public void push(int num) {
        // 相当于插入排序的步骤
        if (countElem != 0) {
            int i = countElem - 1;
            for (; i >= 0; ) {
                if (num >= arr[i]) {
                    arr[i + 1] = arr[i];
                     i--;
                } else {
                    break;
                }
            }
            arr[i + 1] = num;
            countElem++;
            System.out.println("插入元素：" + num);
        } else {
            arr[0] = num;
            countElem = 1;
            System.out.println("当前队列为空，插入第一个元素：" + num);
        }
        getQueue();
    }

    public void pop() {
        int front = countElem - 1;
        if (!isEmpty()) {
            System.out.println("删除队首元素：" + arr[front--]);
            countElem--;
            getQueue();
        }
    }

    public void getQueue() {
        for (int i = 0; i < countElem; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        if (countElem == 0) {
            System.out.println("队列为空！！！");
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (countElem == size) {
            System.out.println("队列已满！！！");
            getQueue();
            return true;
        } else {
            return false;
        }
    }
}
