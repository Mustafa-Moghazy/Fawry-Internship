package org.example.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class AccountManagerTest {

    AccountManager accountManager = new AccountManagerImpl();

    @Test
    void depositShouldBeSuccessWithPositiveValue(){
        // Arrange
        int initialBalance = 100;
        int amount = 100;
        Customer customer = new Customer();
        customer.setBalance(initialBalance);

        // Act
        accountManager.deposit(customer, amount);

        // Assert
        Assertions.assertEquals(customer.getBalance(), initialBalance + amount);
    }

//    @Test
//    void depositShouldBeFailedWithNegativeValue() {
//        // Arrange
//        int initialBalance = 100;
//        int negativeAmount = -50;
//        Customer customer = new Customer();
//        customer.setBalance(initialBalance);
//
//        // Act
//        accountManager.deposit(customer, negativeAmount);
//
//        // Assert
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            accountManager.deposit(customer, negativeAmount);
//        }, "Deposit with a negative amount should throw IllegalArgumentException");
//
//        Assertions.assertEquals(initialBalance, customer.getBalance());
//    }

    @Test
    void WithdrawShouldBeSuccessWhenExpectedBalanceGreaterThanZero() {
        // Arrange
        int amount = 50;
        Customer customer = new Customer();
        customer.setBalance(80);

        // Act
        String result = accountManager.withdraw(customer, amount);

        // Assertion
        assertThat(result).isEqualTo("success");
        assertThat(customer.getBalance()).isEqualTo(30);
    }
    @Test
    void withdrawShouldBeSuccessWhenUserIsCreditAllowedAndExpectedBalanceGreaterThanMAxCreditAndUserISVIP(){
        // arrange
        int initialAmount = 100;
        int withdrawAmount = 10000;
        Customer customer = new Customer();
        customer.setCreditAllowed(true);
        customer.setBalance(initialAmount);
        customer.setVip(true);

        // act
        String result = accountManager.withdraw(customer, withdrawAmount);

        // assert
        assertThat(result).isEqualTo("success");
    }
    @Test
    void withdrawShouldBeSuccessWhenUserIsCreditAllowedAndExpectedBalanceLessThanMAxCredit(){
        // arrange
        int initialAmount = 10;
        int withdrawAmount = 100;
        Customer customer = new Customer();
        customer.setCreditAllowed(true);
        customer.setBalance(initialAmount);

        // act
        String result = accountManager.withdraw(customer, withdrawAmount);

        // assert
        assertThat(result).isEqualTo("success");
    }

    @Test
    void withDrawShouldBeFailedWhenExpectedBalanceLessThanZeroAndUserIsNotCreditAllowed(){
        // arrange
        int amount = 100;
        Customer customer = new Customer();
        customer.setCreditAllowed(false);

        //act
        String result = accountManager.withdraw(customer, amount);

        //arrange
        Assertions.assertEquals(result, "insufficient account balance");
    }
    @Test
    void withDrawShouldBeFailedWhenUserIsCreditAllowedAndExpectedBalanceGreaterThanMAxCreditAndUserISNotVIP(){
        // arrange
        int initialAmount = 100;
        int withdrawAmount = 10000;
        Customer customer = new Customer();
        customer.setCreditAllowed(true);
        customer.setBalance(initialAmount);
        customer.setVip(false);

        // act
        String result = accountManager.withdraw(customer, withdrawAmount);

        // assert
        Assertions.assertEquals(result, "maximum credit exceeded");
    }
}
