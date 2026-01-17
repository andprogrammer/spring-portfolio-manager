package com.portfolio.asset.model;

import com.portfolio.asset.core.AssetType;
import com.portfolio.asset.core.Money;
import com.portfolio.asset.core.ValuableAsset;

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
        return new Money(calculation, purchaseValue.currency());
    }

    public LocalDate maturityDate() {
        return purchaseDate.plusMonths(durationMonths);
    }

    public boolean isMatured() {
        return LocalDate.now().isAfter(maturityDate());
    }
}
