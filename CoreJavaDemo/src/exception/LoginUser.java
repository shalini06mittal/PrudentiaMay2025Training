package exception;

public class LoginUser {

    public void validate(String username, String password) throws InvalidCredenitalsException {
        if(username!=null && !username.isBlank()){
            if(username.equals("user"))
            {
                if(password.equals("user")){
                    return;
                }
                throw new InvalidCredenitalsException("Invalid password");
            }
            throw new InvalidCredenitalsException("Cannot find username");

        }
       throw new NullPointerException("Username cannot be empty");
    }
}
