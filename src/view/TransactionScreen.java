package view;

import java.util.Scanner;

public class TransactionScreen implements CommonScreenIntf {

    @Override public void show() {
        Boolean onScreen = true;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("1. Withdraw \n2. Fund Transfer \n3. Exit");
            System.out.println("Please Choose Option[3]: ");
            String option = in.nextLine();
            switch (option) {
            case "1":
                WithdrawScreen withdrawScreen = new WithdrawScreen();
                withdrawScreen.show();
                break;
            case "2":
                FundTransferDestinationScreen fundTransferDestinationScreen = new FundTransferDestinationScreen();
                fundTransferDestinationScreen.show();
                break;
            case "3":
                onScreen = false;
                WelcomeScreen welcomeScreen = new WelcomeScreen();
                welcomeScreen.show();
                break;
            default:
                if (option.isEmpty()) {
                    onScreen = false;
                } else {
                    System.out.println("Invalid Option");
                }
            }
        } while (onScreen);
    }

}
