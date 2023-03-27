import java.util.*;

public class Bank {

    private Map<String, Account> accounts = new HashMap<>();
    private final Random random = new Random();

    public boolean isFraud()
        throws InterruptedException {

        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) {

        try {
            Account fromAccount = accounts.get(fromAccountNum);
            Account toAccount = accounts.get(toAccountNum);

            if (fromAccount.isBlocked() || toAccount.isBlocked()) {
                System.out.println("Один из аккаунтов заблокирован. Операция отменена");
                return;
            }

            if (amount > fromAccount.getMoney()) {
                System.out.println("Недостаточно средств для перевода. Операция отменена");
                return;
            }

            long fromAccountBalance = fromAccount.getMoney();
            long toAccountBalance = toAccount.getMoney();

            fromAccount.setMoney(fromAccountBalance - amount);
            toAccount.setMoney(toAccountBalance + amount);

            if (amount > 50000 && isFraud()) {
                fromAccount.setBlocked(true);
                toAccount.setBlocked(true);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void newAccount(String accNumber, long money) {
        if (accounts.containsKey(accNumber)) {
            System.out.println("Такой аккаунт уже существует. Операция отменена");
            return;
        }

        Account account = new Account(accNumber, money);
        accounts.put(accNumber, account);
    }
    public long getBalance(String accountNum) {

        if (accounts.get(accountNum).isBlocked()) {
            System.out.println("Аккаунт заблокирован. Операция отменена");
            return 0;
        }

        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        long sum = 0;

        for (String key : accounts.keySet()) {
            sum += accounts.get(key).getMoney();
        }

        return sum;
    }
}
