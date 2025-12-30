package com.portfolio.springPortfolioManager.model.asset;

import com.portfolio.springPortfolioManager.model.asset.impl.Asset;
import com.portfolio.springPortfolioManager.model.asset.impl.AssetType;
import com.portfolio.springPortfolioManager.model.asset.monetaryUnit.MonetaryUnit;

import java.time.LocalDate;

public record Crypto(MonetaryUnit cryptoCurrency,
                     MonetaryUnit currency,
                     LocalDate purchaseDate,
                     double quantity,
                     double pricePerUnit
) implements Asset {

    @Override
    public AssetType type() {
        return AssetType.CRYPTO;
    }

    @Override
    public String name() {
        return cryptoCurrency.getName();
    }

    @Override
    public Money purchaseValue() {
        return new Money(quantity * pricePerUnit, currency);
    }
}
