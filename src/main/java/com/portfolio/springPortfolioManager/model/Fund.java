package com.portfolio.springPortfolioManager.model;

import com.portfolio.springPortfolioManager.model.impl.Asset;
import com.portfolio.springPortfolioManager.model.impl.AssetType;

import java.time.LocalDate;

public record Fund(String name,
                   LocalDate purchaseDate,
                   double units,
                   double purchaseUnitPrice
) implements Asset {

    @Override
    public AssetType type() {
        return AssetType.FUND;
    }

    public double purchaseValue() {
        return units * purchaseUnitPrice;
    }
}
