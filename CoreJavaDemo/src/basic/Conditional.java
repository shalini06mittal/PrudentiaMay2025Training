package basic;

import java.util.Scanner;

public class Conditional {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter minutes");
        int min = sc.nextInt();// 128
        int hours = min / 60;//2
        int rmins = min % 60; //8
        // 02:08
        String hr = ""+hours, mins = ""+rmins;
        if(hours < 10 || rmins < 10){
            hr = "0"+hr;
            mins = "0"+rmins;
        }
//        if(rmins < 10){
//           mins = "0"+rmins;
//        }
        System.out.println(hr+":"+mins);
    }
}
