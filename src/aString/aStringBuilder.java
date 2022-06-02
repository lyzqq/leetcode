package aString;

/**
 * @Author Lyz
 * @Date: 2022/4/20 20:34
 * @Version 1.0
 */
public class aStringBuilder {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("hello");
        // append();
        sb.append(" Java!");
        System.out.println(sb); // hello Java!

        // insert()
        sb.insert(7, "66");
        System.out.println(sb); // hello J66ava!

        // delete()
        sb.delete(7, 9);
        System.out.println(sb); // hello Java!

        // deleteCharAt()
        sb.deleteCharAt(10);
        System.out.println(sb); // hello Java

        // replace()
        sb.replace(5,6,"&");
        System.out.println(sb); // hello&Java

        // setChatAt()
        sb.setCharAt(5, ' ');
        System.out.println(sb); // hello Java

        // reverse()
        sb.reverse();
        System.out.println(sb); // avaJ olleh
    }
}
