package atx1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author Lyz
 * @Date: 2022/4/21 21:52
 * @Version 1.0
 */
public class T2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ArrayList<Integer> count1 = new ArrayList<>();
        ArrayList<Integer> count2 = new ArrayList<>();

        for (int i = 0, j = height.length - 1; i < height.length && j >= 0; i++, j--) {
            count1.add(stack1.size());
            count2.add(0,stack2.size());
            while (!stack1.empty() && stack1.peek() <= height[i]) {
                stack1.pop();
            }
            while (!stack2.empty() && stack2.peek() <= height[j]) {
                stack2.pop();
            }
            stack1.push(height[i]);
            stack1.push(height[j]);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(count1.get(i) + count2.get(i) + 1 + " ");
        }
    }
}
