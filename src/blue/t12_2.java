package blue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @Author Lyz
 * @Date: 2022/3/10 21:01
 * @Version 1.0
 */
public class t12_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        n = n / 1000;
//        n -= 8*60*60*1000;
//        Date date = new Date(n);
//        //创建日期格式化器
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
//        //格式化从键盘输入的数据
//        String format = simpleDateFormat.format(date);
//        System.out.println(format);

        long day = 24 * 60 * 60;
        long hour = 60 * 60;
        long minute = 60;
//        long second = 1000;
        long left_day_SS = n % day;
        long h = left_day_SS / hour;
        long m = (left_day_SS % hour) / 60;
        long s = (left_day_SS % hour) % 60;
//        n = n / 1000;
//        int s = (int) (n % (24 * 60 * 60))
        System.out.printf("%02d:%02d:%02d",h,m,s);
    }
}
