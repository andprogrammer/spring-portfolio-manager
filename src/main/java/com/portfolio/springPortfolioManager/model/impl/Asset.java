package com.portfolio.springPortfolioManager.model.impl;

import java.time.LocalDate;

public interface Asset {

    AssetType type();
    String name();
    LocalDate purchaseDate();
    double purchaseValue();
    default double profit() {
        return purchaseValue();
    }
}
