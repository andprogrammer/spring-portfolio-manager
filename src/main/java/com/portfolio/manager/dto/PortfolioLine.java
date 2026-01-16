package com.portfolio.manager.dto;

import com.portfolio.asset.core.Money;

import java.time.LocalDate;

public record PortfolioLine(
        String assetType,
        String name,
        LocalDate purchaseDate,
        Money purchaseValue,
        Money profit // can be null
) {
}
