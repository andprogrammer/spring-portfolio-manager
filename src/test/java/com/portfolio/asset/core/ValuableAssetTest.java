package com.portfolio.asset.core;

import com.portfolio.asset.unit.Currency;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValuableAssetTest {

    @Test
    void shouldCalculateProfitCorrectly() {
        ValuableAsset asset = new ValuableAsset() {

            @Override
            public Money purchaseValue() {
                return new Money(200, Currency.PLN);
            }

            @Override
            public Money currentValue() {
                return new Money(150, Currency.PLN);
            }

            @Override
            public AssetType type() {
                return AssetType.STOCK;
            }

            @Override
            public String name() {
                return "Test Asset";
            }

            @Override
            public LocalDate purchaseDate() {
                return LocalDate.now();
            }
        };

        Money profit = asset.profit();

        assertEquals(-50, profit.amount());
        assertEquals(Currency.PLN, profit.currency());
    }
}
