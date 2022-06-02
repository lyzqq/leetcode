package dataStructure.d1stack;

import java.util.Arrays;

/**
 * @Author Lyz
 * @Date: 2022/4/22 10:04
 * @Version 1.0
 */
public class Stack<T> {
    private T[] elementData;
//    private int size;
    private int max;
    private int items;

    //构造方法
//    public Stack(int[] elementData, T usedSize) {
//        this.elementData = new Object[5];
//        this.usedSize = 0; // 当前位置
//    }

    public Stack(int size) {
        max = size;
        elementData = (T[]) new Object[max];
        items = 0;
    }

    public Stack() {
    }

    // 入栈
    public void push(T t) {
        // 判满，扩容
        if (isFull()) {
            max = max * 3 / 2 + 1;
            this.elementData = Arrays.copyOf(this.elementData, max);
        }
        this.elementData[items++] = t;
//        this.usedSize++;    // 长度加1
    }

    // 出栈
    public T pop() {
        // 栈空
        if (isEmpty()) {
            throw new RuntimeException("栈空，无法出栈"); // 应该自己写个异常类
        }
        T t = peek();
        items--;
        // int ret = elementData[usedSize];
        elementData[items] = null;
        // elementData[usedSize] = null 如果是引用类型的话
        return t;
    }

    // 获取顶部元素
    public T peek() {

        T t = null;
        // 栈空
        if (isEmpty()) {
            throw new RuntimeException("栈空，无法查看栈顶元素");
        } else {
            t = (T) elementData[items - 1];
        }
        return t;
    }

    private boolean isEmpty() {
        if (items == 0) {
            return true;
        }
        return false;
    }

    private boolean isEmpty2() {
        return items == 0;
    }

    private boolean isFull() {
        if (items == this.elementData.length) {
            return true;
        }
        return false;
    }

    private boolean isFull2() {
        return items == this.elementData.length;
    }

    // 计算长度
    public int size() {
        return items;
    }

    @Override
    public String toString() {
        return Arrays.toString(elementData);
    }
}
