package techgatha.service;

import techgatha.exception.UserNotExistsException;

public interface Rechargeable {
    void recharge(String phone, double amount) throws UserNotExistsException;
}
