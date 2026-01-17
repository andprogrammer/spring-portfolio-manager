package com.portfolio.asset.model;

import com.portfolio.asset.core.Money;
import com.portfolio.asset.model.builders.BondBuilder;
import com.portfolio.asset.unit.Currency;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BondTest {

    @Test
    void shouldCalculateCurrentValue() {
        Bond bond = new BondBuilder()
                .withName("Bond")
                .withPurchaseValue(new Money(10_000, Currency.PLN))
                .withAnnualInterestRate(5)
                .withDurationMonths(24)
                .withPurchaseDate(LocalDate.of(2024, 1, 1))
                .build();

        Money value = bond.currentValue();

        assertEquals(11_000, value.amount(), 0.01);
    }

    @Test
    void shouldReturnCorrectMaturityDate() {
        Bond bond = new BondBuilder()
                .withName("Bond")
                .withPurchaseDate(LocalDate.of(2024, 1, 1))
                .withDurationMonths(12)
                .build();

        assertEquals(LocalDate.of(2025, 1, 1), bond.maturityDate());
    }

    @Test
    void shouldDetectMaturedBond() {
        Bond bond = new BondBuilder()
                .withName("Bond")
                .withPurchaseDate(LocalDate.now().minusMonths(13))
                .withDurationMonths(12)
                .build();

        assertTrue(bond.isMatured());
    }
}