package t13;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Lyz
 * @Date: 2022/2/27 12:35
 * @Version 1.0
 */
public class T13 {
    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};
    public int romanToInt(String s) {
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                res -= value;
            } else {
                res += value;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        T13 t13 = new T13();
        String s = "MCMXCIV";
        System.out.println(t13.romanToInt(s));
    }
}
