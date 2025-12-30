package com.portfolio.springPortfolioManager.model.asset;

import com.portfolio.springPortfolioManager.model.asset.impl.Asset;
import com.portfolio.springPortfolioManager.model.asset.impl.AssetType;

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
