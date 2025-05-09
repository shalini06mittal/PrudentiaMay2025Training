package exception;

public class LoginTest {
    public static void main(String[] args) {
        LoginUser user = new LoginUser();
        try {
            user.validate("user","user");
            System.out.println("success");

        } catch (InvalidCredenitalsException e) {
            System.out.println(e.getMessage());
        }

    }
}

