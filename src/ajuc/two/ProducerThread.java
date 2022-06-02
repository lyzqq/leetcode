package ajuc.two;

import ajuc.one.PublicQueue;

/**
 * @Author Lyz
 * @Date: 2022/5/11 16:19
 * @Version 1.0
 * 生产者线程
 */
public class ProducerThread extends Thread{
    private ajuc.one.PublicQueue publicQueue;

    public ProducerThread(PublicQueue publicQueue) {
        this.publicQueue = publicQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 60; i++) {
            publicQueue.add(String.valueOf(i));
        }
    }
}
