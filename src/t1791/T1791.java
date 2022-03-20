package t1791;

/**
 * @Author Lyz
 * @Date: 2022/2/23 20:17
 * @Version 1.0
 */
public class T1791 {

    public int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }

    public static void main(String[] args) {
        T1791 t1791 = new T1791();
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        System.out.println(t1791.findCenter(edges));
    }
}
