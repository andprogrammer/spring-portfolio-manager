package com.portfolio.asset.core;

public interface ValuableAsset extends Asset {

    /**
     * Current market value of the asset.
     */
    Money currentValue();

    /**
     * Profit = current value - purchase value
     */
    default Money profit() {
        return currentValue().subtract(purchaseValue());
    }
}
