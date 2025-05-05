package basic;

import java.util.Scanner;

public class ConditionaNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("enter a no");
//        int no = sc.nextInt();
//        if (no > 0) {
//            System.out.println("+ve");
//        }
//        else if(no == 0)
//            System.out.println("its ZERO");
//        else{
//            System.out.println("-ve");
//        }

        // leap year - 1900
        System.out.println("enter Leap year");
        int year = sc.nextInt();
        if( ( year % 4 ==0 && year %100!=0) || (year % 400 == 0))
            System.out.println("leap year");
        else
            System.out.println("not leap year");

    }
}
