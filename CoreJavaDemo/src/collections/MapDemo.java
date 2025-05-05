package collections;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("Java", 10);
        map.put("C#", 8);
        map.put("HTML", 15);
        System.out.println(map.put("React", 5));
        System.out.println(map.put("React", 25));
        System.out.println(map);
        System.out.println(map.get("Java"));

        List<String> names = Arrays.asList("Shalini","Ajay","Shalini","Prashant","Ajay","Ajay");
        // get the count of each name in the list
        Map<String, Integer> mapCount = new HashMap<>();
        for(String name : names){

            if(mapCount.get(name) ==null){
                mapCount.put(name, 1);
            }
            else{
                int count = mapCount.get(name);
                count = count+1;
                mapCount.put(name, count);
            }

//            mapCount.putIfAbsent(name, 0);
//            int count = mapCount.get(name);
//            count = count+1;
//            mapCount.put(name, count);
        }
        System.out.println(mapCount);
    }
}
