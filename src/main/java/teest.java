import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.xml.crypto.Data;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class teest {
    public static void main(String[] args) {
        //test1();
        //test3();
        System.out.println("method4......");
        method4();
    }

    private static void method4() {
        System.out.println("method3,准备合并!");
        System.out.println(StringUtils.isBlank(" "));
        String str=null;
        System.out.println(StringUtils.trim(str)+"!!");
    }

    private static void test3() {
        test2();
        String str="yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter dateTimeFormatter= DateTimeFormat.forPattern(str);
        System.out.println(dateTimeFormatter.parseDateTime("2019-8-20 18:29:00").toDate());
    }

    private static void test2() {
        DateTime dateTime = new DateTime(2018, 8, 2, 0, 00, 0);
        System.out.println(dateTime.toDate());

        DateTime dateTimeIn=new DateTime(2019,1,2,0,0,0);
        DateTime dateTimeOut=new DateTime(2019,2,2,0,0);
        System.out.println(Days.daysBetween(dateTimeIn,dateTimeOut).getDays());


    }

    private static void test1() {
        DateTime dt=new DateTime(new Date());
        System.out.println(dt.getYear());
        System.out.println(dt.getMonthOfYear());
        System.out.println(dt.getDayOfMonth());
    }
}
