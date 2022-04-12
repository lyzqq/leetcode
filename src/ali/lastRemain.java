package ali;

/**
 * @Author Lyz
 * @Date: 2022/4/5 20:42
 * @Version 1.0
 */
public class lastRemain {
    public static void main(String[] args) {
        int n = 8, m = 3;
        System.out.println(LastRemaining_Solution(n, m));
    }

    private static int LastRemaining_Solution(int n, int m) {
        boolean[] flags = new boolean[n];
        for(int i = 0; i < n; i++) {
            flags[i] = true;
        }
        int count = 0, t = 0;
        for(int i = 0; i < n; ++i) {
            if(flags[i]) {
                count++;
                if(count == m) {
                    flags[i] = false;
                    t++;
                    count = 0;
                }
            }
            if(i == n - 1) i = -1;
            if(t == n - 1) break;
        }
        for(int i = 0; i < n; i++) {
            if(flags[i]) return i;
        }
        return 0;
    }
}
