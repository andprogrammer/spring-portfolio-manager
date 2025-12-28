package com.portfolio.springPortfolioManager.model;

import com.portfolio.springPortfolioManager.model.impl.AssetType;
import com.portfolio.springPortfolioManager.model.impl.ValuableAsset;

import java.time.LocalDate;

public record Bond(String name,
                   double purchaseValue,
                   LocalDate purchaseDate,
                   double annualInterestRate,
                   int durationMonths
) implements ValuableAsset {

    @Override
    public AssetType type() {
        return AssetType.BOND;
    }

    @Override
    public double currentValue() {
        double years = durationMonths / 12.0;
        return purchaseValue * (1 + (annualInterestRate / 100) * years);
    }

    public LocalDate maturityDate() {
        return purchaseDate.plusMonths(durationMonths);
    }

    public boolean isMatured() {
        return LocalDate.now().isAfter(maturityDate());
    }
}
