package com.portfolio.asset.model;

import com.portfolio.asset.core.Asset;
import com.portfolio.asset.core.AssetType;
import com.portfolio.asset.core.Money;
import com.portfolio.asset.unit.MonetaryUnit;

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
