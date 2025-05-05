package inheritance;
// child or sub or derived
public class Furniture extends Item{

    private String warranty;

//    public Furniture(){
//        System.out.println("Furniture default");
//    }

    public Furniture(int id, String name, double price, String description,String warranty) {
        super(id, name, price, description);
        System.out.println("Furniture param");
        this.warranty = warranty;
    }

    @Override
    public double calculateMrp() {
        System.out.println("furniture calcualate");
        return getPrice() + getPrice() * 0.12;

    }

    // method overriding
    @Override
    public String toString() {
        return  super.toString()+
                "Furniture{" +
                "warranty='" + warranty + '\'' +
                '}';
    }
}
