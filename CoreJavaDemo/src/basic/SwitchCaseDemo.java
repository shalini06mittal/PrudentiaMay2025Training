package basic;

import java.util.Scanner;

public class SwitchCaseDemo {

    public int x(){
        int flag = 0;
        for (int i = 0; i < 10; i++) {
            if(i%3==0) {
                flag = -1;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        /**
         * 1. java 7
         * short int byte char
         * 2. java 8
         * String
         */
        Scanner sc = new Scanner(System.in);
        String country = sc.next();
        switch (country){
            case "India":
                // display states
                break;
                case "USA":
                // display states
                break;
        }
        // java 12 :
        int count[] = switch (country){
            case "India", "China" -> new int[]{
                10
            };
            case "USA" -> new int[]{
                    106
            };
            default -> new int[0];
        };
        System.out.println(count.length);
    }
}
