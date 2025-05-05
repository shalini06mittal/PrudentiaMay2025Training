package interfaces;

public class CreditCard implements  Payment{
    @Override
    public void pay() {
        System.out.println("credit card logic");
    }
}
