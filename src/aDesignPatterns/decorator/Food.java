package aDesignPatterns.decorator;

/**
 * @Author Lyz
 * @Date: 2022/5/8 9:46
 * @Version 1.0
 */
public class Food {
    private String foodName;

    public Food() {
    }

    public Food(String foodName) {
        this.foodName = foodName;
    }
    public String make() {
        return foodName;
    }
}
