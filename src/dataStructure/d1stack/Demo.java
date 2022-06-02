package dataStructure.d1stack;

/**
 * @Author Lyz
 * @Date: 2022/4/22 10:33
 * @Version 1.0
 */
public class Demo {

    public static void main(String[] args) {
//        int[] nums = new int[5];
//        int k = 0;
        Stack<Integer> stack = new Stack<>(5);
        System.out.println(stack.toString());
        stack.push(2);
        System.out.println(stack.toString());
        int num = stack.pop();
        System.out.println(num);
        System.out.println(stack.toString());
        stack.push(4);
        System.out.println(stack.toString());
        int peek1 = stack.peek();
        System.out.println(peek1);
        System.out.println(stack.toString());

        stack.push(3);
        System.out.println(stack.toString());
        int peek2 = stack.peek();
        System.out.println(peek2);
        System.out.println(stack.toString());

        int pop2 = stack.pop();
        System.out.println(pop2);
        System.out.println(stack.toString());

        stack.push(3);
        stack.push(32);
        stack.push(31);
        stack.push(40);
        stack.push(50);
        stack.push(50);
        stack.push(50);
        System.out.println(stack.toString());
        stack.pop();
        stack.pop();
        System.out.println(stack.toString());
    }
}
