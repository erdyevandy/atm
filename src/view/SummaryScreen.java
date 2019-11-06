package view;

import util.ATMConstant;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class SummaryScreen implements CommonScreenIntf {

    double amount;

    public SummaryScreen(double amount) {
        this.amount = amount;
    }

    public SummaryScreen() {

    }

    @Override public void show() {
        Date today = new Date();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(today.toInstant(), ZoneId.systemDefault());
        Scanner in = new Scanner(System.in);
        System.out
                .println("Summary \nDate :" + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a")));
        System.out.println("Withdraw : " + new DecimalFormat("$#,##0").format(amount));
        System.out.println(
                "Balance : " + new DecimalFormat("$#,##0").format(ATMConstant.loginAccount.getBalance()) + "\n");
        System.out.println("1. Transaction \n2. Exit \nChoose option[2]: ");
        String option = in.nextLine();
        switch (option) {
        case "1":
            TransactionScreen transactionScreen = new TransactionScreen();
            transactionScreen.show();
            break;
        default:
            WelcomeScreen welcomeScreen = new WelcomeScreen();
            welcomeScreen.show();
            break;
        }
    }
}
