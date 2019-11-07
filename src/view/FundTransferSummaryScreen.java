package view;

import util.ATMConstant;

import java.util.Scanner;

public class FundTransferSummaryScreen implements CommonScreenIntf {
    Scanner       in            = new Scanner(System.in);
    String        destinationAccount;
    double        transferAmount;
    String        refNumber;
    WelcomeScreen welcomeScreen = new WelcomeScreen();

    public FundTransferSummaryScreen(String destinationAccount, double transferAmount, String refNumber) {
        this.destinationAccount = destinationAccount;
        this.transferAmount = transferAmount;
        this.refNumber = refNumber;
    }

    @Override public void show() {
        System.out.println("Fund Transfer Summary");
        System.out.println("Destination Account : " + destinationAccount);
        System.out.println("Transfer Amount : " + refNumber);
        System.out.println("Balance : " + ATMConstant.loginAccount.getBalance());

        System.out.println("1. Transaction \n2. Exit \nChoose Option[2]: ");
        String option = in.nextLine();
        switch (option) {
        case "1":
            TransactionScreen transactionScreen = new TransactionScreen();
            transactionScreen.show();
            break;
        case "2":
            welcomeScreen.show();
            break;
        default:
            welcomeScreen.show();
        }
    }
}
