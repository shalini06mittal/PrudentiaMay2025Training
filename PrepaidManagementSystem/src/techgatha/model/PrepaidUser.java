package techgatha.model;

import techgatha.util.Type;

import java.util.ArrayList;
import java.util.List;

public class PrepaidUser extends User  {
    private double balance;
    private List<Transaction> transactions;

    public PrepaidUser(String mobile, String name, Plan plan) {
        super(mobile, name, plan);
        this.balance = 0;
        this.transactions = new ArrayList<>();

    }

    public void addTransaction(Type type, double amt) {
        transactions.add(new Transaction(type, amt));
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return super.toString()+ "PrepaidUser{" +
                "balance=" + balance +
                ", transactions=" + transactions +
                '}';
    }
}
