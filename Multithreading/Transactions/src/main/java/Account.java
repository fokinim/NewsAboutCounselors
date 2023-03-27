public class Account {

    private long money;
    private String accNumber;

    private boolean isBlocked;

    public Account(String accNumber, long money) {
        this.money = money;
        this.accNumber = accNumber;
        this.isBlocked = false;
    }

    public synchronized long getMoney() {
        return money;
    }

    public synchronized void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public synchronized boolean isBlocked() {
        return isBlocked;
    }

    public synchronized void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}
