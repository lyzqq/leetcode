package dataStructure.d4HashMap;

import java.util.HashMap;

/**
 * @Author Lyz
 * @Date: 2022/4/23 9:31
 * @Version 1.0
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("a1",1);
        map.put("a2",2);
        System.out.println("size: " + map.size());
        System.out.println("isEmpty: " + map.isEmpty());
        System.out.println(map.get("a2"));
        System.out.println(map);
    }
}
