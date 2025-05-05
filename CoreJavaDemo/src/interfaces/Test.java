package interfaces;

public class Test {

    public static void choosePayment(Payment payment){
        payment.pay();
    }
    public static void main(String[] args) {
        CreditCard cc = new CreditCard();
        choosePayment(cc);
        UPI upi = new UPI();
        choosePayment(upi);
    }
}
