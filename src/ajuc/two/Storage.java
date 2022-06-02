package ajuc.two;


import javafx.scene.effect.Bloom;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Lyz
 * @Date: 2022/5/11 17:37
 * @Version 1.0
 */
public class Storage {
    private final int MAX_SIZE = 10;
    private LinkedList<Object> list = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition full = lock.newCondition();
    private final Condition empty = lock.newCondition();

    public void produce() {
        lock.lock();
        while (list.size() + 1 > MAX_SIZE) {
            System.out.println("【生产者" + Thread.currentThread().getName()
                    + "】仓库已满");
            try {
                full.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(new Object());
        System.out.println("【生产者" + Thread.currentThread().getName()
                + "】生产一个产品，现库存" + list.size());
        empty.signalAll();
        lock.unlock();
    }

    public void consumer() {
        lock.lock();
        while (list.size() == 0) {
            System.out.println("【消费者" + Thread.currentThread().getName()
                    + "】仓库为空");
            try {
                empty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.remove();
        System.out.println("【消费者" + Thread.currentThread().getName()
                + "】消费一个产品，现库存" + list.size());
        full.signalAll();
        lock.unlock();
    }
}
