package aString;

/**
 * @Author Lyz
 * @Date: 2022/4/20 17:11
 * @Version 1.0
 */
public class aString {
    public static void main(String[] args) {
        String s1 = "helloll";
        String s2 = "helloll";
        // equals()
        System.out.println(s1.equals(s2)); // true
        // indexOf()
        System.out.println(s1.indexOf("l")); // 2
        // lastIndexOf()
        System.out.println(s1.lastIndexOf("l")); // 6
        // startsWith
        System.out.println(s1.startsWith("hel"));// true
        // endsWith
        System.out.println(s1.endsWith("oll"));// true
        // contains
        System.out.println(s1.contains("llol"));// true
        // subString
        System.out.println(s1.substring(2)); // lloll
        System.out.println(s1.substring(0, 2)); // he

        String s3 = "   \rHello\n\t   ";
        // trim()
        System.out.println(s3.trim()); // Hello
        // replace()
        String s4 = "helloll";
        System.out.println(s4.replace('l', 'n')); // hennonn
        String s5 = "A,B,C;D";
        System.out.println(s5.replaceAll("[\\,\\;\\s]", ",")); // A,B,C,D

        // join()
        String[] arr = {"A", "B", "C", "D"};
        String s6 = String.join("**", arr);
        System.out.println(s6); // A**B**C**D


        // format()
        String s7 = "Hi %s, your score is %d!";
        System.out.println(String.format(s7, "Alice", 80)); // Hi Alice, your score is 80!
        System.out.println(String.format("Hi %s, your score is %.2f!", "Bob", 59.5)); // Hi Bob, your score is 59.50!

        // valueOf()
        String s8 = String.valueOf(123);
        String s9 = String.valueOf(123.123);
        String s10 = String.valueOf(true);
        String s11 = String.valueOf(new Object());
        System.out.println(s8); // "123"
        System.out.println(s9); // "123.123"
        System.out.println(s10); // "true"
        System.out.println(s11); // "java.lang.Object@5cad8086"

        // parseInt()
        String s12 = "123";
        String s13 = "ff";
        int n1 = Integer.parseInt(s12);
        int n2 = Integer.parseInt(s13, 16);
        System.out.println(n1); // 123
        System.out.println(n2); // 255

        // parseBoolean()
        System.out.println(Boolean.parseBoolean("true")); // true
        System.out.println(Boolean.parseBoolean("FALSE")); // false

        // toCharArray()
        char[] cs = "Hello".toCharArray();
        String s14 = new String(cs);
        System.out.println(s14); // Hello
        cs[0] = 'X';
        System.out.println(s14); // Hello
    }
}
