package util;

import java.util.List;

public interface ValidationServiceIntf {

    List<String> login(String account, String pin);

    List<String> validateAmountWithdraw(double amount);
}
