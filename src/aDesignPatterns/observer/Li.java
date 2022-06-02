package aDesignPatterns.observer;

/**
 * @Author Lyz
 * @Date: 2022/5/8 9:41
 * @Version 1.0
 */
public class Li implements Person {
    private String name = "小李";

    public Li() {
    }

    @Override
    public void getMessage(String s) {
        System.out.println(name + "接到了老板的电话，电话内容是" + s);
    }
}
