package aDesignPatterns.factory;

/**
 * @Author Lyz
 * @Date: 2022/5/8 10:09
 * @Version 1.0
 */
public class Factory {
    public static Car getCarInstance(String type) {
        Car c = null;
        if ("Benz".equals(type)) {
            c = new Benz();
        }
        if ("Ford".equals(type)) {
            c = new Ford();
        }
        return c;
    }
}
