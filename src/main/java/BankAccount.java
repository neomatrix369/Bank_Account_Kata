/**
 * Created by saiubuntu on 22/05/14.
 */
public class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public int deposit(int anyAmountOfMoney) {
        balance = balance + anyAmountOfMoney;
        return balance;
    }
}
