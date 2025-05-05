package techgatha.model;

import techgatha.util.Type;

import java.time.LocalDate;

public class Transaction {

    private Type type;
    private double amount;
    private LocalDate date = LocalDate.now();

    public Transaction(Type type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }


    public String toString() {
        return "[" + date + "] " + type + ": Rs. " + amount;
    }

}
