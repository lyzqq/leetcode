package ajuc.two;

import ajuc.one.PublicQueue;

/**
 * @Author Lyz
 * @Date: 2022/5/11 16:21
 * @Version 1.0
 */
public class ConsumerThread extends Thread{
    private ajuc.one.PublicQueue publicQueue;

    public ConsumerThread(PublicQueue publicQueue) {
        this.publicQueue = publicQueue;
    }

    @Override
    public void run() {
        for(;;) {
            publicQueue.remove();
        }
    }
}
