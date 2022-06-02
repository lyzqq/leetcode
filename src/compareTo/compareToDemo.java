package compareTo;

/**
 * @Author Lyz
 * @Date: 2022/4/20 21:19
 * @Version 1.0
 */
public class compareToDemo {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "c";
        System.out.println(s1.compareTo(s2)); // -2
        String s3 = "aa";
        String s4 = "ae";
        System.out.println(s3.compareTo(s4)); // -4
        System.out.println(s1.compareTo(s4)); // -1
        Integer num1 = 3;
        Integer num2 = 2;
        Integer num3 = 3;
        Integer num4 = 8;
        System.out.println(num1.compareTo(num2)); // 1
        System.out.println(num1.compareTo(num3)); // 0
        System.out.println(num1.compareTo(num4)); // -1
    }
}
