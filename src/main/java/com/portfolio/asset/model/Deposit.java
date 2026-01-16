package com.portfolio.asset.model;

import com.portfolio.asset.core.Asset;
import com.portfolio.asset.core.AssetType;
import com.portfolio.asset.core.Money;

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
