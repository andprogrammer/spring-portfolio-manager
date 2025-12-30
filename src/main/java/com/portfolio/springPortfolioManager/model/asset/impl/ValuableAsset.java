package com.portfolio.springPortfolioManager.model.asset.impl;

import com.portfolio.springPortfolioManager.model.asset.Money;

public interface ValuableAsset extends Asset {

    Money currentValue();

    default Money profit() {
        return currentValue().subtract(purchaseValue());
    }
}
