package account;


import java.util.List;

public interface AccountService {
    String deposit(Account account);
    String withdraw(Account account);
    String getBalance(String accountNumber);
}
