package atx;


import java.util.*;
/**
 * @Author Lyz
 * @Date: 2022/4/21 21:35
 * @Version 1.0
 *
 * 链接：https://www.nowcoder.com/questionTerminal/e542dfa97dd842578875fa592c982dbb?orderByHotValue=1&questionTypes=000100&mutiTagIds=1194&page=1
 * 来源：牛客网
 *
 * 数据结构基础之一——队列
 * 队列有五种基本操作，插入队尾、取出队首、删除队首、队列大小、清空队列。
 *
 * 现在让你模拟一个队列的操作，具体格式参考输入。
 *
 * 注意本题有多组输入。
 * 数据范围： 操作数满足 0 \le n \le 100000 \0≤n≤100000  ，读入的数都满足 0 \le val \le 1000 \0≤val≤1000
 * 进阶：空间复杂度 O(n)\O(n)  ，所有操作的时间复杂度都满足 O(1) \O(1)
 *
 * 输入描述:
 * 第一行输入一个整数T，表示接下来有T组测试数据。
 * 对于每组测试数据：
 * 第一行输入一个整数Q，表示有Q次操作。
 * 接下来Q行，每行输入一种队列操作方式，具体格式如下：
 *
 * 初始状态下队列为空。
 *
 * 插入队尾：PUSH X
 * 取出队首：TOP//仅仅是看一下队首元素，不要把队首元素删除
 * 删除队首：POP
 * 队列大小：SIZE
 * 清空队列：CLEAR
 *
 * 1<=T<=100
 * 1<=Q,x<=1000
 * 保证操作为以上5种的任意一种。
 *
 *
 * 输出描述:
 * 对于每组测试数据：
 * 如果操作为“取出队首”，输出队首元素，如果无法取出，输出“-1”
 * 如果操作为“删除队首”，如果无法删除，输出“-1”
 * 如果操作为“队列大小”，输出队列大小
 * 其他操作无需输出
 * 示例1
 * 输入
 * 2
 * 7
 * PUSH 1
 * PUSH 2
 * TOP
 * POP
 * TOP
 * POP
 * POP
 * 5
 * PUSH 1
 * PUSH 2
 * SIZE
 * POP
 * SIZE
 * 输出
 * 1
 * 2
 * -1
 * 2
 * 1
 */

public class T4 {
    public static void main(String[] args) {
        //输入数组和n
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int T = Integer.parseInt(line);
        int Max = 1000;//？
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < T; i++) {//T组测试数据
            Queue queue = new Queue(Max);//一个队列反复操作 则需要环形队列
            String line1 = sc.nextLine();
            int Q = Integer.parseInt(line1);//Q次操作
            for (int j = 0; j < Q; j++) {//Q次操作   把需要打印的操作的结果存放到一个数组res中 最后轮流换行打印输出
                String s = sc.nextLine();
                String[] s1 = s.split(" ");
                switch (s1[0]) {
                    case "PUSH": //插入队尾元素无返回
                        queue.push(s1[1]);
                        break;
                }
                switch (s1[0]) {
                    case "SIZE": //队列大小
                        res.add(queue.size());
                        break;
                }
                switch (s1[0]) {
                    case "TOP": //队列首元素查询
                        res.add(queue.top());
                        break;
                }
                switch (s1[0]) {
                    case "POP": //删除队首元素
                        if(queue.pop()!=null){
                            res.add(queue.pop());
                        }
                        break;
                }
                switch (s1[0]) {
                    case "CLEAR":
                        queue.clear();//清空队列 无返回
                        break;
                }
            }


        }
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

}

class Queue {
    private int Maxsize;
    private int front;//指向队首
    private int rear;//指向队尾元素的后一个位置 初值为0
    private int[] arr;//存放数据

    public Queue(int maxsize) {
        Maxsize = maxsize;
        arr =new int[Maxsize];//数组不初始化，就是null 也无索引也无0
        front = 0;
        rear = 0;
    }

    public void push(String s) {
        int x = Integer.parseInt(s);
        arr[rear] = x;
        rear = (rear + 1) % Maxsize;
    }

    public Integer size() {
        return (rear - front + Maxsize) % Maxsize;
    }

    public Integer top() {
        if (rear == front) {//为空无法取出
            return -1;
        }
        return arr[front];
    }

    public Integer pop() {
        if (rear == front) { //为空无法删除
            return -1;
        }
        front = (front + 1) % Maxsize;//注意是加1取模  不改变arr 这就算删除队列一个元素了
        return null;
    }

    public void clear() {
        rear=front;//清空队列？？
    }
}
