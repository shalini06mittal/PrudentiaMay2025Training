package oops;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Test {
    public static void main(String[] args) {
        CallDetails ob1 = new CallDetails("298472899724","234727","Voice",LocalDateTime.now(),null);
        System.out.println(ob1);
        int x = 10;
        System.out.println(x);
        ob1.setCaller("2983712");
        System.out.println(ob1.getStart());
//        ob1.receiver ="+91-1897389472";
//        ob1.start = LocalDateTime.now();
//        ob1.end = LocalDateTime.of(LocalDate.of(2025,5,5)
//        , LocalTime.of(12, 25, 25));
//        ob1.type="Voice".toUpperCase();

//        ob1.caller = "897897779";
        CallDetails ob2 = new CallDetails();
        ob2.setCaller("9080808");
//        ob2.receiver ="1897389472";
//        ob2.start = LocalDateTime.now();
//        ob2.end = LocalDateTime.of(LocalDate.of(2025,5,5)
//                , LocalTime.of(12, 25, 25));
//        ob2.type="Voice";
    }
}

