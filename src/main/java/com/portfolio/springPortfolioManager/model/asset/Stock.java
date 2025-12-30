package com.portfolio.springPortfolioManager.model.asset;

import com.portfolio.springPortfolioManager.model.asset.impl.Asset;
import com.portfolio.springPortfolioManager.model.asset.impl.AssetType;
import com.portfolio.springPortfolioManager.model.asset.monetaryUnit.MonetaryUnit;

import java.time.LocalDate;

public record Stock(String name,
                    MonetaryUnit currency,
                    LocalDate purchaseDate,
                    int quantity,
                    double pricePerUnit
) implements Asset {

    @Override
    public AssetType type() {
        return AssetType.STOCK;
    }

    @Override
    public Money purchaseValue() {
        return new Money(quantity * pricePerUnit, currency);
    }
}
