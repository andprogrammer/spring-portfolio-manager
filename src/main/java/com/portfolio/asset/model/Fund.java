package com.portfolio.asset.model;

import com.portfolio.asset.core.Asset;
import com.portfolio.asset.core.AssetType;
import com.portfolio.asset.core.Money;
import com.portfolio.asset.unit.MonetaryUnit;

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
