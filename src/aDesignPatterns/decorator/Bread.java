package aDesignPatterns.decorator;

/**
 * @Author Lyz
 * @Date: 2022/5/8 9:47
 * @Version 1.0
 * 面包类
 */
public class Bread extends Food{
    private Food basicFood;

    public Bread(Food basicFood) {
        this.basicFood = basicFood;
    }

    @Override
    public String make() {
        return basicFood.make() + " + 面包";
    }
}
