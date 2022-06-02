package aDesignPatterns.decorator;

/**
 * @Author Lyz
 * @Date: 2022/5/8 9:49
 * @Version 1.0
 * 奶油类
 */
public class Cream extends Food {
    private Food basicFood;

    public Cream(Food basicFood) {
        this.basicFood = basicFood;
    }

    @Override
    public String make() {
        return basicFood.make() + " + 奶油";
    }
}
