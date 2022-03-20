package t1094;

/**
 * @author 刘勇志
 * @version 1.0
 * <p>
 * 还没成功
 * <p>
 * 1094. 拼车
 * 假设你是一位顺风车司机，车上最初有 capacity 个空座位可以用来载客。由于道路的限制，
 * 车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向，你可以将其想象为一个向量）。
 * 这儿有一份乘客行程计划表 trips[][]，其中 trips[i] = [num_passengers,
 * start_location, end_location] 包含了第 i 组乘客的行程信息：
 * 必须接送的乘客数量；
 * 乘客的上车地点；
 * 以及乘客的下车地点。
 * 这些给出的地点位置是从你的 初始 出发位置向前行驶到这些地点所需的距离
 * （它们一定在你的行驶方向上）。
 * 请你根据给出的行程计划表和车子的座位数，来判断你的车是否可以顺利完成接送所有乘客的任务
 * （当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false）。
 * 示例 1：
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
 * 输出：false
 * 示例 2：
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
 * 输出：true
 * 示例 3：
 * 输入：trips = [[2,1,5],[3,5,7]], capacity = 3
 * 输出：true
 * 示例 4：
 * 输入：trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
 * 输出：true
 */
public class T1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips[trips.length - 1][2];
        int[] res = new int[n];
        for (int i = 0; i < trips.length; i++) {
            for (int j = trips[i][1] - 1; j < n; j++) {
                if (j < trips[i][2] - 1) {
                    res[j] += trips[i][0];
                } else {
                    res[j] = 0;
                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        T1094 t1094 = new T1094();
//        int[][] trips = {{2,1,5},{3,5,7}};
        int[][] trips = {{8, 2, 3}, {4, 1, 3}, {1, 3, 6}, {8, 4, 6}, {4, 4, 8}};
        int capacity = 12;
        System.out.println(t1094.carPooling(trips, capacity));
    }
}
