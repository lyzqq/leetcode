package aDesignPatterns.matches;

/**
 * @Author Lyz
 * @Date: 2022/5/8 10:00
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Phone phone = new Phone();
        VoltageAdapter adapter = new VoltageAdapter();
        phone.setAdapter(adapter);
        phone.charge();
    }
}
