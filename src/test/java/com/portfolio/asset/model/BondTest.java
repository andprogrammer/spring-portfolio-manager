package com.portfolio.asset.model;

import com.portfolio.asset.core.Money;
import com.portfolio.asset.unit.Currency;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BondTest {

    @Test
    void shouldCalculateCurrentValue() {
        Bond bond = new Bond(
                "Bond",
                new Money(10_000, Currency.PLN),
                LocalDate.of(2024, 1, 1),
                5,
                24
        );

        Money value = bond.currentValue();

        assertEquals(11_000, value.amount(), 0.01);
    }

    @Test
    void shouldReturnCorrectMaturityDate() {
        Bond bond = new Bond(
                "Bond",
                new Money(1_000, Currency.PLN),
                LocalDate.of(2024, 1, 1),
                5,
                12
        );

        assertEquals(LocalDate.of(2025, 1, 1), bond.maturityDate());
    }

    @Test
    void shouldDetectMaturedBond() {
        Bond bond = new Bond(
                "Bond",
                new Money(1_000, Currency.PLN),
                LocalDate.now().minusMonths(13),
                5,
                12
        );

        assertTrue(bond.isMatured());
    }
}
