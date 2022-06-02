package aDesignPatterns.matches;

/**
 * @Author Lyz
 * @Date: 2022/5/8 9:57
 * @Version 1.0
 */
public class VoltageAdapter {
    // 改变电压的功能
    public void changeVoltage() {
        System.out.println("正在充电...");
        System.out.println("原始电压：" + Phone.V + "V");
        System.out.println("经过变压器转换之后的电压：" + (Phone.V - 200) + "V");
    }

}
