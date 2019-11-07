package view;

import util.ATMConstant;
import util.ValidationService;

import java.util.List;
import java.util.Scanner;

public class FundTransferDestinationScreen implements CommonScreenIntf {
    Scanner           in                = new Scanner(System.in);
    TransactionScreen transactionScreen = new TransactionScreen();
    ValidationService validationService = new ValidationService();
    Double            amount            = 0.0;
    boolean           valid             = false;

    @Override public void show() {
        System.out.println(
                "Please enter destination account and press enter to continue or press enter to go back to Transaction: ");
        String destinationAccount = in.nextLine();
        if (destinationAccount.isEmpty()) {
            transactionScreen.show();
        }
        try {
            System.out.println(
                    "Please enter transfer amount and press enter to continue or press enter to go back to Transaction: ");
            amount = Double.valueOf(in.nextLine());
            if (amount == null) {
                transactionScreen.show();
            }
        } catch (NumberFormatException ex) {
            System.out.println("Invalid ammount");
        }
        String refNumber = ATMConstant.generateRandomNumber();
        System.out.println("Reference Number: " + refNumber + "\npress enter to continue");

        List<String> errors = validationService.validateFundTransfer(destinationAccount, amount, refNumber);
        if (errors.isEmpty()) {
            FundTransferConfirmationScreen fundTransferConfirmationScreen = new FundTransferConfirmationScreen(
                    destinationAccount, amount, refNumber);
            fundTransferConfirmationScreen.show();
        }
        for (String error : errors) {
            System.out.println(error);
        }

    }
}
