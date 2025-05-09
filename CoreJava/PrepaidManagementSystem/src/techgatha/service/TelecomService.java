package techgatha.service;

import techgatha.dao.UserDAO;
import techgatha.exception.InsufficientBalanceException;
import techgatha.exception.UserExistsException;
import techgatha.exception.UserNotExistsException;
import techgatha.model.Plan;
import techgatha.model.PrepaidUser;
import techgatha.model.Transaction;
import techgatha.util.Type;

public class TelecomService implements  Rechargeable, Usable{
    private final UserDAO dao;

    public TelecomService(UserDAO dao) {
        this.dao = dao;
    }

    public void addUser(String mobile, String name, Plan plan) throws UserExistsException {
        if (dao.exists(mobile)) {
            throw new UserExistsException("⚠️ User already exists.");
        } else {
            dao.saveUser(new PrepaidUser(mobile, name, plan));
            System.out.println("✅ User added.");
        }
    }

    public void recharge(String mobile, double amt) throws UserNotExistsException {
        PrepaidUser user = (PrepaidUser) dao.getUser(mobile);
        if (user != null) {
            user.setBalance(user.getBalance()+amt);
            user.addTransaction(Type.RECHARGE, amt);
            System.out.println("✅ Recharged Rs. " + amt + ". New balance: Rs. " + user.getBalance());
        } else {
            throw new UserNotExistsException("❌ User not found.");
        }
    }

    public void useService(String mobile, Type type, double qty) throws UserNotExistsException, InsufficientBalanceException {
        PrepaidUser user = (PrepaidUser) dao.getUser(mobile);
        if (user == null) {
            throw new UserNotExistsException("❌ User not found.");
        }
        double cost = switch (type) {
            case CALL -> qty * user.getPlan().getCallRate();
            case SMS -> qty * user.getPlan().getSmsRate();
            case DATA -> qty * user.getPlan().getDataRate();
            default -> -1;
        };

        if (cost == -1) {
            System.out.println("❌ Invalid service type.");
        } else if (user.getBalance() < cost) {
            throw new InsufficientBalanceException("❌ Insufficient balance. Need Rs. " + cost + ", available Rs. " + user.getBalance());
        } else {
            user.setBalance(user.getBalance()-cost);
            user.addTransaction(type, cost);
            System.out.println("✅ Used " + type + ". Rs. " + cost + " deducted. Balance: Rs. " + user.getBalance());
        }
    }

    public void showBalance(String mobile) throws UserNotExistsException {
        PrepaidUser user = (PrepaidUser) dao.getUser(mobile);
        if (user != null) {
            System.out.println("📞 " + user.getName() + ": Rs. " + user.getBalance());
        } else {
            throw  new UserNotExistsException("❌ User not found.");
        }
    }

    public void showTransactions(String mobile) throws UserNotExistsException {
        PrepaidUser user = (PrepaidUser) dao.getUser(mobile);
        if (user != null) {
            for(Transaction transaction : user.getTransactions()){
                System.out.println(transaction);
            }
        } else {
           throw new UserNotExistsException("❌ User not found.");
        }
    }


}
