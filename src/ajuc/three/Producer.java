package ajuc.three;

/**
 * @Author Lyz
 * @Date: 2022/5/11 17:45
 * @Version 1.0
 */
public class Producer implements Runnable {

    private Storage storage;

    public Producer() {
    }

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                storage.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
