package aDesignPatterns.observer;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lyz
 * @Date: 2022/5/8 9:42
 * @Version 1.0
 */
public class Boss {
    List<Person> list = new ArrayList<>();

    public Boss() {
    }
    public void addPerson(Person person) {
        list.add(person);
    }
    // 遍历 list， 发送消息给员工
    public void notifyPerson() {
        for (Person person : list) {
            person.getMessage("今天加班，代码有bug！");
        }
    }
}
