package techgatha.service;

import techgatha.exception.InsufficientBalanceException;
import techgatha.exception.UserNotExistsException;
import techgatha.util.Type;

public interface Usable {
    void useService(String mobile,Type type, double quantity) throws InsufficientBalanceException, UserNotExistsException;
}
