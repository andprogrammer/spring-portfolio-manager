package com.portfolio.springPortfolioManager.model.asset;

import com.portfolio.springPortfolioManager.model.asset.monetaryUnit.MonetaryUnit;

public record Money(double amount, MonetaryUnit currency) {

    public Money add(Money other) {
        if (!currency.equals(other.currency)) {
            throw new IllegalArgumentException("Currencies must match to add");
        }
        return new Money(amount + other.amount, currency);
    }

    public Money subtract(Money other) {
        if (!currency.equals(other.currency)) {
            throw new IllegalArgumentException("Currencies must match to subtract");
        }
        return new Money(amount - other.amount, currency);
    }
}
