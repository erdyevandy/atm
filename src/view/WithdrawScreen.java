package view;

import util.ATMConstant;

import java.util.Scanner;

public class WithdrawScreen implements CommonScreenIntf {

    private static final String INSUFFICIENT_BALANCE = "Insufficient balance ";

    @Override public void show() {
        boolean onScreen = true;
        Scanner in = new Scanner(System.in);
        double balance = ATMConstant.loginAccount.getBalance();
        do {
            System.out.println("1. $10 \n2. $50 \n3. $100 \n4. Other \n5. Back");
            System.out.println("Please Choose Option[5]: " + ATMConstant.loginAccount.getBalance());
            String option = in.nextLine();
            switch (option) {
            case "1":
                if (balance < Double.valueOf(10.0)) {
                    System.out.println(INSUFFICIENT_BALANCE + balance);
                    break;
                }
                balance = balance - Double.valueOf(10.0);
                break;
            case "2":
                if (balance < Double.valueOf(50.0)) {
                    System.out.println(INSUFFICIENT_BALANCE + balance);
                    break;
                }
                balance = balance - Double.valueOf(50.0);
                break;
            case "3":
                if (balance < Double.valueOf(100.0)) {
                    System.out.println(INSUFFICIENT_BALANCE + balance);
                    break;
                }
                balance = balance - Double.valueOf(100.0);
                break;
            case "4":
                OtherWithdrawScreen otherWithdrawScreen = new OtherWithdrawScreen();
                otherWithdrawScreen.show();
            case "5":
                TransactionScreen transactionScreen = new TransactionScreen();
                transactionScreen.show();
            default:
                if (option.isEmpty()) {
                    onScreen = false;
                } else {
                    System.out.println("Invalid Option");
                }
            }
            ATMConstant.loginAccount.setBalance(balance);
        } while (onScreen);
    }

}
