package view;

import util.ATMConstant;

import java.util.Scanner;

public class FundTransferConfirmationScreen implements CommonScreenIntf {
    Scanner in = new Scanner(System.in);
    String  accountNo;
    double  transferAmount;
    String  refNumber;

    public FundTransferConfirmationScreen(String accountNo, double transferAmount, String refNumber) {
        this.accountNo = accountNo;
        this.transferAmount = transferAmount;
        this.refNumber = refNumber;
    }


    @Override public void show() {
        System.out.println("Transfer Confirmation");
        System.out.println("Destination Account : " + accountNo);
        System.out.println("Transfer Amount : " + transferAmount);
        System.out.println("Reference Number : " + refNumber);

        System.out.println("1. Confirm Trx \n2. Cancel Trx \nChoose Option[2]: ");
        String option = in.nextLine();
        double balance = ATMConstant.loginAccount.getBalance();
        switch (option) {
        case "1":
            ATMConstant.loginAccount.setBalance(balance + transferAmount);
            FundTransferSummaryScreen fundTransferSummaryScreen = new FundTransferSummaryScreen(accountNo,
                    transferAmount, refNumber);
            fundTransferSummaryScreen.show();
        case "2":
            TransactionScreen transactionScreen = new TransactionScreen();
            transactionScreen.show();
        default:
        }
    }
}
