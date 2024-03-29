package util;

import service.AccountService;

import java.util.ArrayList;
import java.util.List;

public class ValidationService implements ValidationServiceIntf {

    AccountService accountService = new AccountService();

    /*
        Validate Input on Welcome Screen
     */
    @Override public List<String> login(String account, String pin) {
        List<String> errors = new ArrayList<>();
        if (account.length() != 6) {
            errors.add("Account Number should have 6 digits length");
        }
        if (!account.matches("[0-9]+")) {
            errors.add("Account Number should only contains numbers");
        }
        if (pin.length() != 6) {
            errors.add("PIN should have 6 digits length");
        }
        if (!pin.matches("[0-9]+")) {
            errors.add("PIN should only contains numbers ");
        }

        return errors;
    }

    //validate amount when user withdraw
    @Override public List<String> validateAmountWithdraw(double amount) {
        List<String> errors = new ArrayList<>();
        if (amount < 0 || amount % 10 != 0) {
            errors.add("Invalid ammount");
        }
        if (ATMConstant.loginAccount.getBalance() < amount) {
            errors.add("Insufficient balance " + amount);
        }

        return errors;
    }

    //validate fund when user Transfer fund
    public List<String> validateFundTransfer(String account, double amount, String refNumber) {
        List<String> errors = new ArrayList<>();
        try {
            if (!account.matches("[0-9]+")) {
                errors.add("Invalid account");
            }
            if (accountService.findAccount(account) == null) {
                errors.add("Invalid account");
            }
            if (amount > Double.valueOf(1000.0)) {
                errors.add("Maximum amount to withdraw is $1000");
            }
            if (amount < Double.valueOf(1.0)) {
                errors.add("Maximum amount to withdraw is $1");
            }
            if (ATMConstant.loginAccount.getBalance() < amount) {
                errors.add("Insufficient balance $" + amount);
            }
            if (!refNumber.matches("[0-9]+") || refNumber.isEmpty()) {
                errors.add("Invalid Reference Number");
            }
        } catch (NumberFormatException ex) {
            errors.add("Invalid ammount");
        }

        return errors;
    }

}
