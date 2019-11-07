package util;

import model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ATMConstant {

    public static Account loginAccount = new Account();

    public static List<Account> generateAccount() {
        List<Account> accounts = new ArrayList<>();
        Account account = new Account();
        account.setName("John Doe");
        account.setPin("012108");
        account.setBalance(100);
        account.setAccountNumber("112233");
        accounts.add(account);

        Account account1 = new Account();
        account1.setName("Jane Doe");
        account1.setPin("932012");
        account1.setBalance(30);
        account1.setAccountNumber("112244");
        accounts.add(account1);

        Account account2 = new Account();
        account2.setName("Erdy");
        account2.setPin("111111");
        account2.setBalance(300);
        account2.setAccountNumber("000000");
        accounts.add(account2);

        return accounts;
    }

    public static String generateRandomNumber() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        return String.format("%06d", number);
    }
}
