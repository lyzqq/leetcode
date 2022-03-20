package blue2;

/**
 * @Author Lyz
 * @Date: 2022/3/11 19:22
 * @Version 1.0
 * 本题总分: 10分
 *
 * [问题描述]
 * 到 x 星球旅行的游客都被发给一个整数，作为游客编号。
 *
 * x 星的国王有个怪癖，他只喜欢数字 3,5 和 7。
 *
 * 国王规定，游客的编号如果只含有因子：3,5,7 就可以获得一份奖品。 前 10 个幸运数字是： 3 5 7 9 15 21 25 27 35 45 ，因而第 11 个幸运数字是：49
 *
 * 小明领到了一个幸运数字 59084709587505。
 *
 * 去领奖的时候，人家要求他准确说出这是第几个幸运数字，否则领不到奖品。
 *
 * 请你帮小明计算一下，59084709587505 是第几个幸运数字。
 *
 * 1905
 */
public class T4 {

    public static void main(String[] args) {
        long n = 59084709587505L;
        int cnt = 0;
        //float i = 3;
        for (int i = 0; Math.pow(3, i) <= n; i++) {
            for (int j = 0; Math.pow(5, j) <= n; j++) {
                for (int k = 0; Math.pow(7, k) <= n; k++) {
                    if (Math.pow(3, i) * Math.pow(5, j) * Math.pow(7, k) <= n){
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt-1);
    }
}
