package aDesignPatterns.decorator;

/**
 * @Author Lyz
 * @Date: 2022/5/8 9:52
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Food food = new Bread(new Vegetable(new Cream(new Food("香肠"))));
        System.out.println(food.make());
    }
}
// 香肠 + 奶油 + 蔬菜 + 面包