package com.portfolio.asset.core;

import java.time.LocalDate;

public interface Asset {
    AssetType type();
    String name();
    LocalDate purchaseDate();
    /**
     * Value at the time of purchase.
     */
    Money purchaseValue();
}
