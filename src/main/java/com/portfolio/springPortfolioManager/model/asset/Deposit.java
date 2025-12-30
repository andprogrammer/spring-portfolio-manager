package com.portfolio.springPortfolioManager.model.asset;

import com.portfolio.springPortfolioManager.model.asset.impl.Asset;
import com.portfolio.springPortfolioManager.model.asset.impl.AssetType;

import java.time.LocalDate;

public record Deposit(String name,
                      Money purchaseValue,
                      LocalDate purchaseDate,
                      double interestRate,
                      int durationMonths
) implements Asset {

    @Override
    public AssetType type() {
        return AssetType.DEPOSIT;
    }

    public LocalDate maturityDate() {
        return purchaseDate.plusMonths(durationMonths);
    }

    public boolean isMatured() {
        return LocalDate.now().isAfter(maturityDate());
    }
}
