package ajuc.one;

/**
 * @Author Lyz
 * @Date: 2022/5/11 16:22
 * @Version 1.0
 */
public class ProducerConsumerTest {

    public static void main(String[] args) {
        PublicQueue publicQueue = new PublicQueue();
        ProducerThread producerThread = new ProducerThread(publicQueue);
        ConsumerThread consumerThread = new ConsumerThread(publicQueue);
        producerThread.start(); // 启动生产者线程
        consumerThread.start(); // 启动消费者线程
    }
}
