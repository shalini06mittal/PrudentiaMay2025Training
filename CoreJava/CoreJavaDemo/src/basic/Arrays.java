package basic;

public class Arrays {
    public static void main(String[] args) {
        // call type -> diff rates
        int x[] = new int[5];
        for (int i = 0; i < x.length; i++) {
            x[i] = (i + 1) * (int)(Math.random()*10);
        }
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
        System.out.println();
        int high = x[0];
        for (int i = 0; i < x.length; i++) {
            if(high < x[i])
                high = x[i];
        }
        System.out.println(high);


    }
}

