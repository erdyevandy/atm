package view;

import model.Account;
import service.AccountService;
import util.ATMConstant;
import util.ValidationService;

import java.util.List;
import java.util.Scanner;

public class WelcomeScreen implements CommonScreenIntf {
    Scanner           in                = new Scanner(System.in);
    ValidationService validationService = new ValidationService();
    TransactionScreen transactionScreen = new TransactionScreen();
    WithdrawScreen withdrawScreen = new WithdrawScreen();
    AccountService    accountService    = new AccountService();

    @Override public void show() {
        System.out.println("Enter Account Number: ");
        String account = in.next();
        System.out.println("Enter PIN: ");
        String pin = in.next();

        List<String> errorMessage = validationService.login(account, pin);
        for (String error : errorMessage) {
            System.out.println(error);
        }

        Account accountLogin = accountService.login(account, pin);
        if (accountLogin != null) {
            ATMConstant.loginAccount = accountLogin;
            transactionScreen.show();

        } else if (accountLogin == null) {
            System.out.println("Invalid Account Number/PIN");
        }

    }

}
