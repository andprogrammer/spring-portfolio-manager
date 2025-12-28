package com.portfolio.springPortfolioManager.model;

import com.portfolio.springPortfolioManager.model.impl.Asset;
import com.portfolio.springPortfolioManager.model.impl.AssetType;
import com.portfolio.springPortfolioManager.model.monetaryUnit.MonetaryUnit;

import java.time.LocalDate;

public record Metal(MonetaryUnit metal,
                    LocalDate purchaseDate,
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
    public double purchaseValue() {
        return quantity * pricePerUnit;
    }
}
