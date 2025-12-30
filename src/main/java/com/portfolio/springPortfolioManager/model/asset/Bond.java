package com.portfolio.springPortfolioManager.model.asset;

import com.portfolio.springPortfolioManager.model.asset.impl.AssetType;
import com.portfolio.springPortfolioManager.model.asset.impl.ValuableAsset;
import com.portfolio.springPortfolioManager.model.asset.monetaryUnit.Currency;

import java.time.LocalDate;

public record Bond(String name,
                   Money purchaseValue,
                   LocalDate purchaseDate,
                   double annualInterestRate,
                   int durationMonths
) implements ValuableAsset {

    @Override
    public AssetType type() {
        return AssetType.BOND;
    }

    @Override
    public Money currentValue() {
        double years = durationMonths / 12.0;
        double calculation = purchaseValue.amount() * (1 + (annualInterestRate / 100) * years);
        return new Money(calculation, Currency.PLN);
    }

    public LocalDate maturityDate() {
        return purchaseDate.plusMonths(durationMonths);
    }

    public boolean isMatured() {
        return LocalDate.now().isAfter(maturityDate());
    }
}
