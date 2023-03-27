import java.util.ArrayList;
import java.util.Random;

public class TransactionsEmulator implements Runnable{
    ArrayList<String> accountList;
    Bank bank;
    public TransactionsEmulator(Bank bank, ArrayList<String> accountList) {
        this.bank = bank;
        this.accountList = accountList;
    }

    @Override
    public void run() {

        Random random = new Random();
        int randomIndex = random.nextInt(accountList.size());
        String account1 = accountList.get(randomIndex);
        randomIndex = random.nextInt(accountList.size());
        String account2 = accountList.get(randomIndex);

        if (account1.equals(account2)){
            return;
        }

        long amount = random.nextInt(60000);

        bank.transfer(account1, account2, amount);
    }
}
