package aDesignPatterns;

/**
 * @Author Lyz
 * @Date: 2022/5/8 9:37
 * @Version 1.0
 * 单例模式
 */
public class Singleton {
    private static  Singleton singleton;

    public Singleton() {
    }
    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
