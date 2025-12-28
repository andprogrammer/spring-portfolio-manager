package com.portfolio.springPortfolioManager.model.impl;

public interface ValuableAsset extends Asset {

    double currentValue();

    default double profit() {
        return currentValue() - purchaseValue();
    }
}
