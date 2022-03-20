package blue4;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author Lyz
 * @Date: 2022/3/19 20:12
 * @Version 1.0
 *
 * 给定当前的时间，请用英文的读法将它读出来。
 *
 * 时间用时h和分m表示，在英文的读法中，读一个时间的方法是：
 *
 * 如果m为0，则将时读出来，然后加上“o'clock”，如3:00读作“three o'clock”。
 *
 * 如果m不为0，则将时读出来，然后将分读出来，如5:30读作“five thirty”。
 *
 * 时和分的读法使用的是英文数字的读法，其中0~20读作：
 *
 * 0:zero, 1: one, 2:two, 3:three, 4:four, 5:five, 6:six, 7:seven, 8:eight, 9:nine, 10:ten, 11:eleven, 12:twelve, 13:thirteen, 14:fourteen, 15:fifteen, 16:sixteen, 17:seventeen, 18:eighteen, 19:nineteen, 20:twenty。
 *
 * 30读作thirty，40读作forty，50读作fifty。
 *
 * 对于大于20小于60的数字，首先读整十的数，然后再加上个位数。如31首先读30再加1的读法，读作“thirty one”。
 *
 * 按上面的规则21:54读作“twenty one fifty four”，9:07读作“nine seven”，0:15读作“zero fifteen”。
 *
 * 输入格式:
 * 输入包含两个非负整数h和m，表示时间的时和分。非零的数字前没有前导0。h小于24，m小于60。
 *
 * 输出格式:
 * 输出时间时刻的英文。
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * 0 15
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * zero fifteen
 */
public class T5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");
        map.put(13, "thirteen");
        map.put(14, "fourteen");
        map.put(15, "fifteen");
        map.put(16, "sixteen");
        map.put(17, "seventeen");
        map.put(18, "eighteen");
        map.put(19, "nineteen");
        map.put(20, "twenty");
        map.put(30, "thirty");
        map.put(40, "forty");
        map.put(50, "fifty");
        String sh = Int2Str(h, map);
        String sm;
        if (m == 0) {
            sm = "o'clock";
        } else {
            sm = Int2Str(m, map);
        }
        StringBuilder sb = new StringBuilder();
        System.out.println((sb.append(sh).append(" ").append(sm)).toString());

    }

    private static String Int2Str(int m, Map<Integer, String> map) {
        if (m >= 0 && m <= 10) {
            return(map.get(m));
        } else if (m > 10 && m <= 20){
            return(map.get(m));
        } else {
            if (m % 10 == 0) {
                return map.get(m / 10 * 10);
            } else {
                return(map.get(m / 10 * 10)+ " " + map.get(m % 10));
            }
        }
    }
}
