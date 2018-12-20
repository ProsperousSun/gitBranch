package sumrize.Lambda;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Demo1 {
    private  static List<Person> javaProgrammers;
    private static List<Person> phpProgrammers;
    public static void main(String[] args) {
        method4();//map集合的lambda表达式的应用
        method3();//list集合的过滤的方法的使用和limit方法的使用
        method2();//匿名内部类的使用
        method1();//list集合的遍历
    }

    private static void method4() {
        Map<String,String> map=new HashMap<>();
        map.put("1","赵");
        map.put("2","钱");
        map.put("3","孙");
        map.put("4","李");
        map.forEach((K,V)-> {
            if (V.equals("孙"))
            System.out.println("k:"+K+"__"+"V"+V);
        });
    }

    private static void method3() {
        //javaProgrammers.forEach((javaProgrammers)-> System.out.println(javaProgrammers+"_"));
        //过滤月薪超过2000的程序员
        phpProgrammers.stream()
                .filter((p)->(p.getSalary()>1400))
                .limit(3)
                .forEach((p)-> System.out.println(p.getSalary()));
        List<Person> phpSortSalary=phpProgrammers.stream()
                .sorted((p1,p2)->(p1.getSalary()-p2.getSalary()))
                .collect(Collectors.toList());
        System.out.println("从小到达的排序");
        phpSortSalary.forEach((p)-> {
            System.out.println(p.getSalary());
        });
    }

    private static void method2() {
        new Thread(() -> {
            System.out.println("Thread->启动起来了");
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("正常的匿名内部类使用的而方法");
            }
        }).start();
    }

    private static void method1() {
        //创建一个集合
        Collection<String> c=new HashSet<String>();
        //需要泛型，否则提示警告:使用了未经检查或不安全的操作，可以直接运行
        c.add("ni");
        c.add("hao");
        c.add("java");
        //不使用lambda表达式和两种使用lambda表达式方式
        c.forEach(t->System.out.println("集合元素是："+t));

    }

    static {
        javaProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
                add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
                add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
                add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
                add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
                add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
                add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
                add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
                add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
                add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
            }
        };

         phpProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
                add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
                add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
                add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
                add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
                add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
                add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
                add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
                add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
                add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
            }
        };
    }
}
