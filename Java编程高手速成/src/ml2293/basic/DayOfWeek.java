package ml2293.basic;

/*
 *  读入年月日，输出星期几
 *  月份m=1 表示1月 January
 *  输出 0 表示星期天 Sunday， 1 表示星期一 Monday， 等等.
 *  计算公式为:
 *        y0 = y - (14 - m) / 12
 *        x = y0 + y0/4 - y0/100 + y0/400
 *        m0 = m + 12 * ((14 - m) / 12) - 2
 *        dayOfWeek = (d + x + (31*m0)/12) mod 7
 *
 *
 *  % java ml2293.basic.DayOfWeek 1949 10 1 
 *  6                              // 星期六 Saturday
 *
 *  % java ml2293.basic.DayOfWeek 2000 1 2  #January 2, 2000
 *  0                              // 星期天 Sunday
 *
 ******************************************************************************/
public class DayOfWeek {

    public static void main(String[] args) {
        int y = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int d = Integer.parseInt(args[2]);

        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;

        System.out.println(d0);
    }
}
