package view;

import util.ATMConstant;
import util.ValidationService;

import java.util.List;
import java.util.Scanner;

public class OtherWithdrawScreen implements CommonScreenIntf {
    ValidationService validationService = new ValidationService();

    @Override public void show() {
        Scanner in = new Scanner(System.in);
        double balance = ATMConstant.loginAccount.getBalance();
        boolean onScreen = true;
        do {
            try {
                System.out.println("Other Withdraw " + balance);
                System.out.println("Enter amount to withdraw: ");
                Double amount = Double.valueOf(in.nextLine());
                List<String> errors = validationService.validateAmountWithdraw(amount);
                if (errors.isEmpty()) {
                    onScreen = false;
                    balance = balance - amount;
                    ATMConstant.loginAccount.setBalance(balance);
                    SummaryScreen summaryScreen = new SummaryScreen(amount);
                    summaryScreen.show();
                } else {
                    for (String error : errors) {
                        System.out.println(error);
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid ammount");
            }
        } while (onScreen);

    }

}
