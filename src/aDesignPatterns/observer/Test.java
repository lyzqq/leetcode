package aDesignPatterns.observer;

/**
 * @Author Lyz
 * @Date: 2022/5/8 9:44
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Boss boss = new Boss();
        Wang wang = new Wang();
        Li li = new Li();
        boss.addPerson(wang);
        boss.addPerson(li);
        boss.notifyPerson();
    }
}
