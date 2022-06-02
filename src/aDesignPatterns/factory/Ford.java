package aDesignPatterns.factory;

/**
 * @Author Lyz
 * @Date: 2022/5/8 10:09
 * @Version 1.0
 */
public class Ford implements Car{
    @Override
    public void run() {
        System.out.println("Ford开始启动了。。。");
    }

    @Override
    public void stop() {
        System.out.println("Ford停车了。。。。");
    }
}
