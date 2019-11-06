import view.FundTransferDestinationScreen;
import view.OtherWithdrawScreen;
import view.SummaryScreen;
import view.WelcomeScreen;

public class Atm {
    public static void main(String[] args) {
        WelcomeScreen welcomeScreenView = new WelcomeScreen();
//        SummaryScreen summaryScreen = new SummaryScreen();
        FundTransferDestinationScreen fundTransferDestinationScreen = new FundTransferDestinationScreen();
        OtherWithdrawScreen otherWithdrawScreen = new OtherWithdrawScreen();
        do {
            welcomeScreenView.show();
        } while (true);
    }
}
