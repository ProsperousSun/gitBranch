import bean.Home;
import com.google.common.annotations.VisibleForTesting;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        System.out.println(new Date().getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(1545753600);
        System.out.println(date);
        //test1();
        //test3();
        //method4();
        //method5();
//        while(true){
//            method6();
//            System.out.println("记性中");
//        }
    }




    @Test
    public void testIntest(){
        Home home=null;
        convertStr(home);
        System.out.println(home);
    }
    public void convertStr(Home home){
        home=getHome();
    }
    public Home getHome(){
        Home home=new Home();
        home.setName("你好不好");
        return home;
    }


    @Test
    public void testCalender(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(10, -24);
        System.out.println(cal.get(Calendar.MONTH));
        System.out.println(cal.get(Calendar.DATE));
    }
    @Test
    public void testIsNotBlank(){
        String str="1";
        System.out.println(StringUtils.isNotEmpty(str));

        String html = StringEscapeUtils.escapeHtml("&");
        System.out.println(html);
    }
    @Test
    public void test01(){
        try {
            int x=2/0;
        }catch (Exception e){
            throw e;
        }
    }
    @Test
    public void da(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int month = cal.get(Calendar.MONTH)+1;
        int result = cal.get(Calendar.YEAR);
        System.out.println(result);
        System.out.println(month);
        for(int i=6;i>0;i--){
            if(month==0){
                month=12;
                result--;
            }
            month--;
        }
        System.out.println(month+" "+result);
    }
    @Test
    public void test02(){
        try {
            test01();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void 当前时间字符串类型增删改查() throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();

        Thread.sleep(2000);
        long sleepCurrentTimeMills=System.currentTimeMillis();
        String strSleepCurrentTiemMills=String.valueOf(sleepCurrentTimeMills);
        System.out.println(strSleepCurrentTiemMills);
        System.out.println(sleepCurrentTimeMills-currentTimeMillis);
    }


    private static void method6() {
        new Thread(()->{
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static void method5() {
        Logger logger = LoggerFactory.getLogger(Main.class);

    }

    private static void method4() {
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
