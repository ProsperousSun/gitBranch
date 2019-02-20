package Lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapSortSet {
    Map<Integer,String> map=new HashMap<>();
    List<Integer> list=new ArrayList<>();
    {
        map.put(1,"map1");
        map.put(2,"map2");
        map.put(3,"map3");
        map.put(4,"map4");
        map.put(5,"map5");

        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void sortMap(){

    }

    @Test
    public void rangeList(){
        List<Integer> list1=new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1 = list1.stream().sorted((o1, o2) -> o2-o1).collect(Collectors.toList());
        System.out.println(list1);
    }
}
