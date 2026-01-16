package com.portfolio.asset.model;

import com.portfolio.asset.core.Asset;
import com.portfolio.asset.core.AssetType;
import com.portfolio.asset.core.Money;

import java.time.LocalDate;

public record Cash(Money purchaseValue,
                   LocalDate purchaseDate
) implements Asset {

    @Override
    public AssetType type() {
        return AssetType.CASH;
    }

    @Override
    public String name() {
        return purchaseValue.currency().toString();
    }
}
