package bluePractice;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Lyz
 * @Date: 2022/4/8 15:34
 * @Version 1.0
 * <p>
 * 1015 德才论 (25 分)
 * 宋代史学家司马光在《资治通鉴》中有一段著名的“德才论”：“是故才德全尽谓之圣人，才德兼亡谓之愚人，德胜才谓之君子，才胜德谓之小人。凡取人之术，苟不得圣人，君子而与之，与其得小人，不若得愚人。”
 * <p>
 * 现给出一批考生的德才分数，请根据司马光的理论给出录取排名。
 * <p>
 * 输入格式：
 * 输入第一行给出 3 个正整数，分别为：N（≤10
 * 5
 * ），即考生总数；L（≥60），为录取最低分数线，即德分和才分均不低于 L 的考生才有资格被考虑录取；H（<100），为优先录取线——德分和才分均不低于此线的被定义为“才德全尽”，此类考生按德才总分从高到低排序；才分不到但德分到优先录取线的一类考生属于“德胜才”，也按总分排序，但排在第一类考生之后；德才分均低于 H，但是德分不低于才分的考生属于“才德兼亡”但尚有“德胜才”者，按总分排序，但排在第二类考生之后；其他达到最低线 L 的考生也按总分排序，但排在第三类考生之后。
 * <p>
 * 随后 N 行，每行给出一位考生的信息，包括：准考证号 德分 才分，其中准考证号为 8 位整数，德才分为区间 [0, 100] 内的整数。数字间以空格分隔。
 * <p>
 * 输出格式：
 * 输出第一行首先给出达到最低分数线的考生人数 M，随后 M 行，每行按照输入格式输出一位考生的信息，考生按输入中说明的规则从高到低排序。当某类考生中有多人总分相同时，按其德分降序排列；若德分也并列，则按准考证号的升序输出。
 * <p>
 * 输入样例：
 * 14 60 80
 * 10000001 64 90
 * 10000002 90 60
 * 10000011 85 80
 * 10000003 85 80
 * 10000004 80 85
 * 10000005 82 77
 * 10000006 83 76
 * 10000007 90 78
 * 10000008 75 79
 * 10000009 59 90
 * 10000010 88 45
 * 10000012 80 100
 * 10000013 90 99
 * 10000014 66 60
 * 输出样例：
 * 12
 * 10000013 90 99
 * 10000012 80 100
 * 10000003 85 80
 * 10000011 85 80
 * 10000004 80 85
 * 10000007 90 78
 * 10000006 83 76
 * 10000005 82 77
 * 10000002 90 60
 * 10000014 66 60
 * 10000008 75 79
 * 10000001 64 90
 */
public class T1015 {

    // 定义一个类存储考生考号分数等信息
    public static class Person implements Comparable<Person> {
        //准考证号
        private int number;
        //德分
        private int dScore;
        //才分
        private int cScore;
        //总分
        private int total;

        public Person(int number, int dScore, int cScore) {
            this.number = number;
            this.dScore = dScore;
            this.cScore = cScore;
            // 总分
            total = dScore + cScore;
        }

        @Override
        public int compareTo(Person o) {
            if (o.total - this.total != 0) {
                return o.total - this.total;
            } else if (o.dScore - this.dScore != 0) {
                return o.dScore - this.dScore;
            } else {
                return this.cScore - o.cScore;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), L = sc.nextInt(), H = sc.nextInt();
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new Person(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        sc.close();
        list = list.stream().filter(v -> v.cScore >= L && v.dScore >= L).collect(Collectors.toList());
        List<Person> list1 = new ArrayList<>();
        List<Person> list2 = new ArrayList<>();
        List<Person> list3 = new ArrayList<>();
        List<Person> list4 = new ArrayList<>();
        for (Person p : list) {
            if (p.dScore >= H && p.cScore >= H) {
                list1.add(p);
            } else if (p.dScore >= H && p.cScore < H) {
                list2.add(p);
            } else if (p.dScore < H && p.cScore < H && p.dScore >= p.cScore) {
                list3.add(p);
            } else {
                list4.add(p);
            }
        }
        int res = list1.size() + list2.size() + list3.size() + list4.size();
        System.out.println(res);
        Collections.sort(list1);
        Collections.sort(list2);
        Collections.sort(list3);
        Collections.sort(list4);
        print(list1);
        print(list2);
        print(list3);
        print(list4);
    }

    private static void print(List<Person> list) {
        for (Person person : list) {
            System.out.println(person.number + " " + person.dScore + " " + person.cScore);
        }
    }
}
