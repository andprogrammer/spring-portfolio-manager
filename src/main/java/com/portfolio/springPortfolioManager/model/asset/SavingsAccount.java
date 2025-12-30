package com.portfolio.springPortfolioManager.model.asset;

import com.portfolio.springPortfolioManager.model.asset.impl.AssetType;
import com.portfolio.springPortfolioManager.model.asset.impl.ValuableAsset;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public record SavingsAccount(String name,
                             String bankName,
                             Money purchaseValue,
                             LocalDate purchaseDate,
                             double annualInterestRate
) implements ValuableAsset {

    @Override
    public AssetType type() {
        return AssetType.SAVINGS_ACCOUNT;
    }

    @Override
    public Money currentValue() {
        long days = ChronoUnit.DAYS.between(purchaseDate, LocalDate.now());
        double years = days / 365.0;
        double result = purchaseValue.amount() * (1 + (annualInterestRate / 100) * years);
        return new Money(result, purchaseValue.currency());
    }
}
