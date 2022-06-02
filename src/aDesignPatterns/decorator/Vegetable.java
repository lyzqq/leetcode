package aDesignPatterns.decorator;

/**
 * @Author Lyz
 * @Date: 2022/5/8 9:47
 * @Version 1.0
 * 面包类
 */
public class Vegetable extends Food{
    private Food basicFood;

    public Vegetable(Food basicFood) {
        this.basicFood = basicFood;
    }

    @Override
    public String make() {
        return basicFood.make() + " + 蔬菜";
    }
}
