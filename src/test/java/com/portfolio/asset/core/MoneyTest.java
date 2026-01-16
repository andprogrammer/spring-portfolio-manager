package com.portfolio.asset.core;

import com.portfolio.asset.unit.Currency;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {

    @Test
    void shouldAddMoneyWithSameCurrency() {
        Money a = new Money(100, Currency.PLN);
        Money b = new Money(50, Currency.PLN);

        Money result = a.add(b);

        assertThat(result.amount()).isEqualTo(150);
    }

    @Test
    void shouldThrowWhenAddingDifferentCurrencies() {
        Money a = new Money(100, Currency.PLN);
        Money b = new Money(50, Currency.USD);

        assertThatThrownBy(() -> a.add(b))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Currencies must match");
    }
}
