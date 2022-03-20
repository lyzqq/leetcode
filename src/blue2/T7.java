package blue2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Lyz
 * @Date: 2022/3/11 20:53
 * @Version 1.0
 * <p>
 * 给定四个整数值的列表A，B，C，D，计算多少个四元组（a，b，c，d）∈A x B x C x D使得a + b + c + d = 0。假定所有列表的大小均相同。
 * <p>
 * 输入格式:
 * 输入文件的第一行包含列表n的大小（此值可以最大为4000）。然后，我们有n行包含四个分别属于A，B，C和D的整数值（绝对值最大为2^28）。
 * <p>
 * 输出格式:
 * 对于每个输入文件，您的程序须计算有多少个四元组，其总和为零。
 * <p>
 * 输入样例:
 * 6
 * -45     22     42   -16
 * -41   -27    56     30
 * -36    53    -37    77
 * -36    30    -75   -46
 * 26   -38   -10    62
 * -32   -54     -6    45
 * 输出样例:
 * 5
 * 提示
 * 示例说明：以下五个四元组的总和为零：（-45，-27、42、30），（26、30，-10，-46），（-32、22、56，-46） ，（-32、30，-75、77），（-32，-54、56、30）。
 */
public class T7 {

    static int n;
    static int[] nums1;
    static int[] nums2;
    static int[] nums3;
    static int[] nums4;
//    static List<Long> list;
    static int k = 0;
    static int res = 0;
    static int[] sum1 = new int[160000010];
    static int[] sum2 = new int[160000010];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums1 = new int[n];
        nums2 = new int[n];
        nums3 = new int[n];
        nums4 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = sc.nextInt();
            nums2[i] = sc.nextInt();
            nums3[i] = sc.nextInt();
            nums4[i] = sc.nextInt();
        }
        k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum1[k++] = nums1[i] + sum2[j];
                sum2[k++] = nums2[i] + nums4[j];
            }
        }

        Arrays.sort(sum2);
        for (int i = 0; i < k; i++) {
            int x = lower_bound(sum2, 0, k, -sum1[i]) - sum2[i];
            while (sum2[x] == -sum2[i] && x < k) {
                res++;
                x++;
            }
        }

        System.out.println(res);
    }
    public static int lower_bound(int[] nums, int begin, int end, int value) {
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] < value) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return begin;
    }

//        sort(sum2,sum2+k);
//        int ans=0;
//        for(int i=0;i<k; i++)
//        {
//            int x=lower_bound(sum2,sum2+k,-sum1[i])-sum2;
//            while(sum2[x]==-sum1[i]&&x<k)
//            {
//                ans++;
//                x++;
//            }
//        }
//        cout<<ans<<endl;
//
//        return 0;

//    static void count(int begin){
//        if(list.size() == 4){
//            if(sum == 0){
//                res++;
//            }
//            return;
//        }
//        for(int i = begin; i < nums.length; i++ ){
//            if(nums.length - i  < 4 - list.size()) return;
//            //if(begin != i && nums[i - 1] == nums[i])continue;
//            if(i < nums.length - 1 && sum + nums[i] + (3 - list.size()) * nums[i + 1] > 0)return;
//            if(i < nums.length - 1 && sum + nums[i] + (3 - list.size()) * nums[nums.length - 1] < 0)continue;
//            sum += nums[i];
//            list.add(nums[i]);
//            count( i + 1);
//            list.remove(list.size() - 1);
//            sum -= nums[i];
//        }
//    }

//    private static int count() {
//        Arrays.sort(nums);
//        for (int i = 0; i < 4 * n - 3; i++) {
//            for (int j = i + 1; i < 4 * n - 2; j++) {
//                int left = j + 1;
//                int right = 4 * n - 1;
//                while (left < right) {
//                    long sum = nums[i] + nums[j] + nums[left] + nums[right];
//                    if (sum == 0) {
//                        res++;
//                        ++left;
//                        --right;
//                    } else if (sum < 0){
//                        ++left;
//                    } else {
//                        --right;
//                    }
//                }
//            }
//        }
//        return res;
//    }
}

