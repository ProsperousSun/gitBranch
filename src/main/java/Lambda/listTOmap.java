package Lambda;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class listTOmap {



    @Test
    public void groupTest(){
        List<Integer> list= Arrays.asList(1,2,3,4,5);
        List<Integer> groupList = list.stream().filter(x -> x % 2 == 0).limit(1).collect(Collectors.toList());
        System.out.println(groupList);
    }

    @Test
    public void listTomap(){
        List list=new ArrayList();
        list.add(new Man(1,"man1"));
        list.add(new Man(2,"man2"));
        list.add(new Man(3,"man3"));
        List list1=new ArrayList();
        list1.add(new Man(4,"man5"));
        list1.add(new Man(5,"man5"));

        List<Man> list3=new ArrayList();
        list3.add(new Man(6,"man4"));
        list3.add(new Man(null,"man5"));

        /**
         * 最普通的一种写法，无需判断key重复和value值为null的时候
         */
        Map<String,Integer> map =
                (Map<String, Integer>) list.stream().collect(Collectors.toMap(Man::getName,man->man.getAge()));
        map.forEach((k,v)->{
            System.out.println(k+":"+v);
        });
        /**
         * 规避key值重复的问题
         * 会出异常java.lang.IllegalStateException: Duplicate key
         */
        Map<String,Man> map1 =
                (Map<String, Man>) list1.stream().collect(Collectors.toMap(Man::getName,man->man,(oldMan,newMan)->newMan));

        /**
         * 规避key值重复的问题
         * 会出异常java.lang.IllegalStateException: Duplicate key
         */
        Map<String,Integer> map2 =
                (Map<String, Integer>) list1.stream().collect(Collectors.toMap(Man::getName,man->man.getAge(),(oldMan,newMan)->newMan));
        map1.forEach((k,v)->{
            System.out.println(k+":"+v);
        });
        map2.forEach((k,v)->{
            System.out.println(k+":"+v);
        });
        /**
         * 规避当value为null时，会抛出异常：java.lang.NullPointerException
         */
//        list3.stream().collect(Collector.)
        System.out.println("list3..."+list3);
        //不可用
//        HashMap<String, Integer> map3 =
//                list3.stream().collect(Collector.of(HashMap::new, (map4, per)->map4.put(per.getName(),per.getAge()), (k, v)->v, Collector.Characteristics.IDENTITY_FINISH));
//        map3.forEach((k,v)->{
//            System.out.println(k+":"+v);
//        });

        Collections.sort(list,(o1, o2) -> {
            Man man1=(Man) o1;
            Man man2=(Man) o2;
            return man1.getAge()-man2.getAge();
        });
//
//        list.stream().forEach(obj->{
//            System.out.println(obj);
//        });
    }

    @Test
    public void pairTest(){
        Pair<Integer, String> pair = new Pair<>(1, "One");
        Integer key = pair.getKey();
        System.out.println(key);
    }



    public static class  Man{
        public Integer age;
        public String name;
        public Man(Integer age,String name){
            this.age=age;
            this.name=name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Man{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
