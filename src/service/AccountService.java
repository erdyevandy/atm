package service;

import model.Account;
import util.ATMConstant;

import java.util.List;

public class AccountService implements AccountServiceIntf {
    List<Account> accountList = ATMConstant.generateAccount();

    @Override public Account login(String account, String pin) {
        for (Account acc : accountList) {
            if (acc.getAccountNumber().equals(account) && acc.getPin().equals(pin)) {
                return acc;
            }
        }
        return null;
    }

    public Account findAccount(String account) {
        for (Account acc : accountList) {
            if (acc.getAccountNumber().equals(account)) {
                return acc;
            }
        }
        return null;
    }
}
