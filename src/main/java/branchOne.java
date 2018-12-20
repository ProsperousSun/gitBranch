import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class branchOne {
    private static final String str="yyyy-MM-dd HH:mm:ss";
    public static void main(String[] args) {
        try {
            System.out.println(2/0);
        }catch (Exception e){
            System.out.println(e);
            System.out.println("---------------");
            System.out.println(e.getMessage());
        }
        //dateTimeConvert();


//        System.out.println("看看这次能不能merge到branchTwo!!!!");
//        method();
//        System.out.println(OverOneYear(new Date()));
    }

    private static void dateTimeConvert() {
        //时间戳转换为正常的 时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        String format = simpleDateFormat.format(1510036464000L);
        System.out.println(format);
    }

    private static void method() {
        System.out.println("这次能够merge成功吧!");
    }

    /**
     * 时间的加上多长的期限，时间的计算方法
     * @param createTime
     * @return
     */
    public static boolean OverOneYear(Date createTime){
        if(createTime!=null){
            Calendar calendar=Calendar.getInstance();
            calendar.setTime(createTime);
            calendar.add(Calendar.YEAR, 1);//增加一年
            calendar.add(Calendar.MONTH,1);
            Date calendarTime = calendar.getTime();
            Date nowDate = new Date();
            if(nowDate.before(calendarTime)){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
}
