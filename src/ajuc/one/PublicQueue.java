package ajuc.one;

/**
 * @Author Lyz
 * @Date: 2022/5/11 16:00
 * @Version 1.0
 * (双向链表LinkedHashMap和synchronized结合)
 */

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 公共缓存队列
 * 只做两件事：（1）生产（2）消费
 *
 * @param <T>
 */
public class PublicQueue<T> {
    private int putIndex = 0; // 数据插入的角标
    private int maxCount = 50; // 缓存区最大长度
    private LinkedHashMap<Integer, T> linkedHashMap = new LinkedHashMap<>(); // 缓冲区

    public synchronized void add(T msg) {
        while (linkedHashMap.size() + 1 > maxCount) {
            // 如果缓存区达到最大数量，则阻塞生产者线程
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        linkedHashMap.put(putIndex, msg);
        putIndex = (putIndex + 1) % maxCount;
        System.out.println("生产一个产品，当前商品角标为: " + putIndex + "===文本为： " + msg + "===缓存长度为：  " + linkedHashMap.size());
        notifyAll(); // 唤醒所有线程
    }

    public synchronized T remove() {
        while (linkedHashMap.size() == 0) {
            // 如果缓存区没有数据，则阻塞消费线程
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        T t = null;
        if (it.hasNext()) {
            Map.Entry<Integer, T> entry = (Map.Entry<Integer, T>) it.next();
            t = entry.getValue();
            int index = entry.getKey();
            linkedHashMap.remove(index);
            System.out.println("消费一个产品，当前商品角标为: " + index + "===文本为： " + t + "===缓存长度为：  " + linkedHashMap.size());
            notifyAll(); // 唤醒所有线程
        }
        return t;
    }
}
