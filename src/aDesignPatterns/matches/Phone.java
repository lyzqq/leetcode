package aDesignPatterns.matches;

/**
 * @Author Lyz
 * @Date: 2022/5/8 9:54
 * @Version 1.0
 */
public class Phone{
    public static final int V = 220; // 正常电压
    private VoltageAdapter adapter;
    // 充电
    public void charge() {
        adapter.changeVoltage();
    }
    public void setAdapter(VoltageAdapter adapter) {
        this.adapter = adapter;
    }
}
