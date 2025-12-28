package com.portfolio.springPortfolioManager.model;

import com.portfolio.springPortfolioManager.model.impl.Asset;
import com.portfolio.springPortfolioManager.model.impl.AssetType;
import com.portfolio.springPortfolioManager.model.monetaryUnit.MonetaryUnit;

import java.time.LocalDate;

public record Cash(double purchaseValue,
                   MonetaryUnit currency,
                   LocalDate purchaseDate
) implements Asset {

    @Override
    public AssetType type() {
        return AssetType.CASH;
    }

    @Override
    public String name() {
        return currency.getName();
    }
}
