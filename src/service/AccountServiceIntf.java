package service;

import model.Account;

public interface AccountServiceIntf {

    // Method for check if account is available or not
    Account login(String account, String pin);
}
