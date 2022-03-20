package t599;

import com.sun.xml.internal.ws.encoding.MtomCodec;

import java.util.*;

/**
 * @Author Lyz
 * @Date: 2022/3/14 12:32
 * @Version 1.0
 * <p>
 * 题目描述
 * 评论 (377)
 * 题解 (490)
 * 提交记录
 * 599. 两个列表的最小索引总和
 * 假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * <p>
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * 示例 2:
 * <p>
 * 输入:list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 */
public class T599 {
    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> index = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            index.put(list1[i], i);
        }
        List<String> res = new ArrayList<>();
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (index.containsKey(list2[i])) {
                int j = index.get(list2[i]);
                if (i + j < sum) {
                    res.clear();
                    res.add(list2[i]);
                    sum = i + j;
                } else if (i + j == sum) {
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[res.size()]);
        /*
        int len1 = list1.length, len2 = list2.length;
        List<String> list = new ArrayList<>();
        //String[] res = new String[Math.min(list1.length, list2.length)];
        int tem, sum = len1 + len2; //k = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (list1[i].equals(list2[j])) {
                    tem = i + j;
                    if (tem < sum) {
                        sum = tem;
                        //k = 0;
                        list.clear();
                        list.add(list1[i]);
                    } else if (tem == sum) {
                        list.add(list1[i]);
                    }
                    break;
                }
            }
        }
//        String[] res = new String[list.size()];
//        for (int i = 0; i < list.size(); ++i) {
//            res[i] = list.get(i);
//        }
        return list.toArray(new String[list.size()]);
        */
    }

    public static void main(String[] args) {
        T599 t599 = new T599();
        String[] list1 = {"Shogun", "Piatti", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        // String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        // String[] list1 = {"KFC", "Shogun", "Burger King"};
        System.out.println(Arrays.toString(t599.findRestaurant(list1, list2)));
    }
}
