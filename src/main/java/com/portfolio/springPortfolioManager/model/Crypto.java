package com.portfolio.springPortfolioManager.model;

import com.portfolio.springPortfolioManager.model.impl.Asset;
import com.portfolio.springPortfolioManager.model.impl.AssetType;
import com.portfolio.springPortfolioManager.model.monetaryUnit.MonetaryUnit;

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
    public double purchaseValue() {
        return quantity * pricePerUnit;
    }
}
