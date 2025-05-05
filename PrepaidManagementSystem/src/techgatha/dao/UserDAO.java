package techgatha.dao;

import techgatha.model.PrepaidUser;
import techgatha.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserDAO {
    private final Map<String, User> userMap = new HashMap<>();

    public void saveUser(PrepaidUser user) {
        userMap.put(user.getMobileNumber(), user);
    }

    public User getUser(String mobile) {
        return userMap.get(mobile);
    }

    public boolean exists(String mobile) {
        return userMap.containsKey(mobile);
    }

}
