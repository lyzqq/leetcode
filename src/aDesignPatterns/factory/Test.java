package aDesignPatterns.factory;

/**
 * @Author Lyz
 * @Date: 2022/5/8 10:10
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Car c = Factory.getCarInstance("Benz");
        if (c != null) {
            c.run();
            c.stop();
        } else {
            System.out.println("没有这种车");
        }
    }
}
