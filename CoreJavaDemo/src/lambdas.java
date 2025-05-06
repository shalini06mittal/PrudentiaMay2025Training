import oops.Addition;

public class lambdas {
    public static void main(String[] args) {

        // anonymous inner class
//        Addition ob = new Addition() {
//            @Override
//            public int add(int a, int b) {
//                return a+b;
//            }
//        };
//        System.out.println(ob.add(23,45));
        // (<parameters) -> {body method}
//        Addition ob = (int a, int b) ->{
//                return a+b;
//            };
        Addition ob = (a,  b) ->  a+b;
        //Addition ob = Integer::sum; // method references
        System.out.println(ob.add(230,45));

    }
}
class IDdition implements Addition{

    @Override
    public int add(int a, int b) {
        return 0;
    }
}
