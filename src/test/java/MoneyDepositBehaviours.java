/*
    Title: Deposit - deposit money into an account

            Narrative:
                As a person (account holder)
                I wish to deposit money into my account
                So that I can have a secure place to save my money
                and increase the balance of my account
*/

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MoneyDepositBehaviours {
    private static final int ZERO_BALANCE = 0;
    private static final int ANY_AMOUNT_OF_MONEY = 500;

    int initialBalance = 0;
    int expectedBalance = 0;

    /*
        Scenario: Deposit money into a new account
            Given a bank account has been created
            And the balance is zero
            When the account holder deposits money into the account
            Then the balance of the account increases by the amount deposited
     */

    @Test
    public void given_A_BankAccountHasBeenCreatedWithZeroBalance_WhenMoneyIsDeposited_ThenBalanceIncreases() {
        // Given
        setupGivenAccountState(ZERO_BALANCE, ANY_AMOUNT_OF_MONEY);

        // When
        int actualBalance = whenBankAccountDepositActionIsPerformed(initialBalance, ANY_AMOUNT_OF_MONEY);

        // Then
        thenTheResultShouldBe(
                "The balance should have increased",
                actualBalance,
                expectedBalance);
    }

    private void thenTheResultShouldBe(String assertMessage, int actualBalance, int expectedBalance) {
        assertThat(assertMessage,
                    actualBalance,
                    is(equalTo(expectedBalance)));
    }

    private int whenBankAccountDepositActionIsPerformed(int initialBalance, int depositAmount) {
        BankAccount bankAccount = new BankAccount(initialBalance);
        return bankAccount.deposit(depositAmount);
    }

    /*

       Scenario: Deposit money into a existing account
       Given a bank account exists
       And the balance exists
       When the account holder deposits money into the account
       Then the balance of the account increases by the amount deposited

     */
    @Test
    public void given_A_BankAccountExistsWithABalance_WhenMoneyIsDeposited_ThenBalanceIncreases() {
         // Given
         int initialBalance = 100;
         int expectedBalance = initialBalance + ANY_AMOUNT_OF_MONEY;

         // When
         BankAccount bankAccount=new BankAccount(initialBalance);
         int actualBalance = bankAccount.deposit(ANY_AMOUNT_OF_MONEY);

         // Then
         assertThat("The balance should have increased",
                 actualBalance,
                 is(equalTo(expectedBalance)));
     }

    private void setupGivenAccountState(int initialBalance, int expectedBalance) {
        this.initialBalance = initialBalance;
        this.expectedBalance = expectedBalance;
    }
}
