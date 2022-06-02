package ajuc.three;

/**
 * @Author Lyz
 * @Date: 2022/5/11 17:46
 * @Version 1.0
 */
public class Consumer implements Runnable{

    private Storage storage;

    public Consumer() {
    }

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
                storage.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
