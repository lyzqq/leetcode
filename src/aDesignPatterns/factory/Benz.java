package aDesignPatterns.factory;

/**
 * @Author Lyz
 * @Date: 2022/5/8 10:07
 * @Version 1.0
 */
class Benz implements Car {

    @Override
    public void run() {
        System.out.println("Benz开始启动了.....");
    }

    @Override
    public void stop() {
        System.out.println("Benz停车了.....");
    }
}
