package ajuc.three;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author Lyz
 * @Date: 2022/5/11 17:43
 * @Version 1.0
 */
public class Storage {
    private LinkedBlockingDeque<Object> list = new LinkedBlockingDeque<>(10);

    public void produce() {
        try {
            list.put(new Object());
            System.out.println("【生产者" + Thread.currentThread().getName()
                    + "】生产一个产品，现库存" + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void consume() {
        try {
            list.take();
            System.out.println("【消费者" + Thread.currentThread().getName()
                    + "】消费了一个产品，现库存" + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
