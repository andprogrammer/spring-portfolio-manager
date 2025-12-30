package com.portfolio.springPortfolioManager.model.asset;

import com.portfolio.springPortfolioManager.model.asset.impl.Asset;
import com.portfolio.springPortfolioManager.model.asset.impl.AssetType;
import com.portfolio.springPortfolioManager.model.asset.monetaryUnit.MonetaryUnit;

import java.time.LocalDate;

public record Metal(MonetaryUnit metal,
                    LocalDate purchaseDate,
                    MonetaryUnit currency,
                    double quantity,
                    double weight,
                    double pricePerUnit
) implements Asset {

    @Override
    public AssetType type() {
        return AssetType.METAL;
    }

    @Override
    public String name() {
        return metal.getName();
    }

    @Override
    public Money purchaseValue() {
        return new Money(quantity * pricePerUnit, currency);
    }
}
