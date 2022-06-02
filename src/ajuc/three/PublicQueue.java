package ajuc.three;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author Lyz
 * @Date: 2022/5/11 16:40
 * @Version 1.0
 * // 阻塞队列
 */
public class PublicQueue<T> {
    // 缓冲区
    private BlockingDeque<T> blockingDeque = new LinkedBlockingDeque<>(50);

    public void add(T msg) {
        try {
            blockingDeque.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("生产一个产品，当前商品角标为："+"===文本为："+msg);
    }

    public T remove() {
        T t = null;
        try {
            t = blockingDeque.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费一个产品，当前商品角标为："+"===文本为："+t);
        return t;
    }
}
