package techgatha.client;

import techgatha.dao.UserDAO;
import techgatha.exception.InsufficientBalanceException;
import techgatha.exception.UserExistsException;
import techgatha.exception.UserNotExistsException;
import techgatha.model.Plan;
import techgatha.service.TelecomService;
import techgatha.util.Type;

import java.util.Scanner;

public class PrepaidMenuSystem {

   // static Plan defaultPlan = new Plan("Standard", 1.0, 0.5, 0.1);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserDAO dao = new UserDAO();
        TelecomService service = new TelecomService(dao);
        Plan defaultPlan = new Plan("Basic", 1.0, 0.5, 0.1);

        int choice;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add User");
            System.out.println("2. Recharge");
            System.out.println("3. Use Service");
            System.out.println("4. Show Balance");
            System.out.println("5. Show Transactions");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter mobile: ");
                    String mobile = sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    try {
                        service.addUser(mobile, name, defaultPlan);
                    } catch (UserExistsException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.print("Enter mobile: ");
                    String mobile = sc.nextLine();
                    System.out.print("Enter amount: ");
                    double amt = sc.nextDouble(); sc.nextLine();
                    try {
                        service.recharge(mobile, amt);
                    } catch (UserNotExistsException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.print("Enter mobile: ");
                    String mobile = sc.nextLine();
                    System.out.print("Enter type (call/sms/data): ");
                    String t = sc.nextLine();
                    System.out.print("Enter quantity: ");
                    double qty = sc.nextDouble(); sc.nextLine();
                    Type type = Type.valueOf(t);
                    try {
                        service.useService(mobile, type, qty);
                    } catch (UserNotExistsException | InsufficientBalanceException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.print("Enter mobile: ");
                    String mobile = sc.nextLine();
                    try {
                        service.showBalance(mobile);
                    } catch (UserNotExistsException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 5 -> {
                    System.out.print("Enter mobile: ");
                    String mobile = sc.nextLine();
                    try {
                        service.showTransactions(mobile);
                    } catch (UserNotExistsException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 6 -> System.out.println("👋 Exit.");
                default -> System.out.println("Invalid option.");
            }

        } while (choice != 6);
    }

}


