package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account("John Doe");
    }

    @Test
    void depositIncreasesBalance() {
        account.deposit(200.0);
        assertEquals(200.0, account.getBalance());
    }

    @Test
    void depositDoesNotAllowNegativeAmount() {
        account.deposit(-50.0);
        assertEquals(0.0, account.getBalance()); // Should remain unchanged
    }

    @Test
    void withdrawReducesBalance() {
        account.deposit(300.0);
        account.withdraw(150.0);
        assertEquals(150.0, account.getBalance());
    }

    @Test
    void withdrawDoesNotAllowOverdraw() {
        account.deposit(200.0);
        account.withdraw(250.0); // Should not be allowed
        assertEquals(200.0, account.getBalance());
    }

    @Test
    void withdrawDoesNotAllowNegativeAmount() {
        account.deposit(100.0);
        account.withdraw(-50.0);
        assertEquals(100.0, account.getBalance()); // Should remain unchanged
    }
}
