package com.portfolio.springPortfolioManager.model.asset.impl;

import com.portfolio.springPortfolioManager.model.asset.Money;

import java.time.LocalDate;

public interface Asset {
    AssetType type();
    String name();
    LocalDate purchaseDate();
    Money purchaseValue();
    default Money profit() {
        return purchaseValue();
    }
}
