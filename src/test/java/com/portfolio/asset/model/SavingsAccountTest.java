package com.portfolio.asset.model;

import com.portfolio.asset.core.Money;
import com.portfolio.asset.unit.Currency;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SavingsAccountTest {

    @Test
    void shouldGrowOverTime() {
        SavingsAccount account = new SavingsAccount(
                "Savings",
                "Bank",
                new Money(10_000, Currency.PLN),
                LocalDate.now().minusYears(1),
                5
        );

        Money value = account.currentValue();

        assertTrue(value.amount() > 10_000);
    }
}
