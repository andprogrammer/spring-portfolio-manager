package com.portfolio.asset.core;

import com.portfolio.asset.unit.MonetaryUnit;

import java.util.Objects;

public record Money(double amount, MonetaryUnit currency) {

    public Money {
        Objects.requireNonNull(currency, "Currency must not be null");

        if (Double.isNaN(amount) || Double.isInfinite(amount)) {
            throw new IllegalArgumentException("Amount must be a finite number");
        }
    }

    public Money add(Money other) {
        requireSameCurrency(other);
        return new Money(this.amount + other.amount, currency);
    }

    public Money subtract(Money other) {
        requireSameCurrency(other);
        return new Money(this.amount - other.amount, currency);
    }

    private void requireSameCurrency(Money other) {
        Objects.requireNonNull(other, "Other money must not be null");

        if (!currency.equals(other.currency)) {
            throw new IllegalArgumentException("Currencies must match");
        }
    }
}
