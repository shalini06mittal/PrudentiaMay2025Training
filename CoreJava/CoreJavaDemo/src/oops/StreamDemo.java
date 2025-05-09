package oops;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class StreamDemo {

    public static void main(String[] args) {
        List<Integer> nos = new ArrayList<>();
        nos.add(12);
        nos.add(2);
        nos.add(22);
        nos.add(15);
//        nos.add(17);
//        for (int i = 0; i < nos.size(); i++) {
//            System.out.println(nos.get(i));
//        }
//        for(Integer n :nos)
//            System.out.println(n*n);
//        //STREAM API -> intermediate, terminal
//        nos.stream().forEach(i -> System.out.println(i*i*i));
//        nos.forEach(i -> System.out.println(i*i*i));

        System.out.println("processeing starts");
       long count = nos.stream()
                .filter(value -> {
                    System.out.println("filter "+ value);
                    return value%2==0;
                })
                .map(value -> value * value)
                .count();
        System.out.println("processeing ends "+count);
    }
}
