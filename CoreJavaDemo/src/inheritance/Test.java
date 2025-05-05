package inheritance;

public class Test {
    public static void main(String[] args) {
        // ob is a reference of type Item
        // referring to object of type furniture
        // dynamic binding / runtime polymorphism
        Item ob = new Furniture(1, "f1",2000,"lovely furniture","12 moonth");
        System.out.println(ob.calculateMrp());
        ob = new Showpieces();
        System.out.println(ob.calculateMrp());

    }
}
