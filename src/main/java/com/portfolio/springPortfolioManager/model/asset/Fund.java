package com.portfolio.springPortfolioManager.model.asset;

import com.portfolio.springPortfolioManager.model.asset.impl.Asset;
import com.portfolio.springPortfolioManager.model.asset.impl.AssetType;
import com.portfolio.springPortfolioManager.model.asset.monetaryUnit.MonetaryUnit;

import java.time.LocalDate;

public record Fund(String name,
                   LocalDate purchaseDate,
                   MonetaryUnit currency,
                   double units,
                   double purchaseUnitPrice
) implements Asset {

    @Override
    public AssetType type() {
        return AssetType.FUND;
    }

    public Money purchaseValue() {
        return new Money(units * purchaseUnitPrice, currency);
    }
}
