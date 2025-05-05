package inheritance;

public class Showpieces  extends  Item{


    private boolean delicate;


    @Override
    public double calculateMrp() {
        System.out.println("Show piece");
        return getPrice() + getPrice() * 0.1;
    }
}

