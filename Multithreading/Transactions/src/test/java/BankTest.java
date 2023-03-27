import com.github.javafaker.Faker;
import junit.framework.TestCase;
import java.util.ArrayList;

public class BankTest extends TestCase {
    ArrayList<String> accountList = new ArrayList<>();
    Bank bank = new Bank();
    @Override
    protected void setUp() throws Exception {

        Faker faker = new Faker();

        for (int i = 0; i < 2500; i++) {
            String accName = faker.idNumber().valid();

            bank.newAccount(accName, 500000);
            accountList.add(accName);
        }
    }

    public void testTransfer() {

        for (int i = 0; i < 100000; i++) {

            TransactionsEmulator emulator = new TransactionsEmulator(bank, accountList);
            new Thread(emulator).start();

        }

        long actual = bank.getSumAllAccounts();
        long expected = 500000 * 2500;

        assertEquals(expected, actual);
    }
}
