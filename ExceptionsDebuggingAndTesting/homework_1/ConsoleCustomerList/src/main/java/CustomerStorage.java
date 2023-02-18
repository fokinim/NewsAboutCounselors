import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;
    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {

        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;
        final String REGEX_EMAIL = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}";
        final String REGEX_PHONE = "|^\\+\\d{10,12}";


            String[] components = data.split("\\s+");

            if (components.length != 4) {
                throw new CustomerException("Неверный набор данных пользователя: " + data);
            } else if (!components[2].matches(REGEX_EMAIL)) {
                throw new CustomerException("Неверный формат e-mail");
            } else if (!components[3].matches(REGEX_PHONE)) {
                throw new CustomerException("Неверный формат номера телефона");
            }

        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
            storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));

    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}