package t470;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 470. 用 Rand7() 实现 Rand10()
 * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10
 * 生成 1 到 10 范围内的均匀随机整数。
 * 不要使用系统的 Math.random() 方法。
 * 示例 1:
 * 输入: 1
 * 输出: [7]
 * 示例 2:
 * 输入: 2
 * 输出: [8,4]
 * 示例 3:
 * 输入: 3
 * 输出: [8,1,10]
 * /**
 * * The rand7() API is already defined in the parent class SolBase.
 * * public int rand7();
 * * @return a random integer in the range 1 to 7
 */


public class T470 extends SolBase {
    public int rand10() {
        int row, col, idx;
        do {
            row = rand7();
            col = rand7();
            idx = col + (row - 1) * 7;
        } while (idx > 40);
        return 1 + (idx - 1) % 10;
    }

    public static void main(String[] args) {
        T470 t470 = new T470();
        System.out.println(t470.rand10());
    }
}

class SolBase {
    public int rand7() {
        return (int) (1 + Math.random() * 7);
    }
}
