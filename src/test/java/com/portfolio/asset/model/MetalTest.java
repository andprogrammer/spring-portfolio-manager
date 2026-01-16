package com.portfolio.asset.model;

import com.portfolio.asset.unit.Currency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class MetalTest {

    Metal metal;

    @BeforeEach
    void setUp() {
        metal = new Metal(com.portfolio.asset.unit.Metal.GOLD,
                LocalDate.of(2024, 3, 8),
                Currency.USD,
                2,
                31.1,
                3500);
    }

    @Test
    void name() {
        Assertions.assertEquals(com.portfolio.asset.unit.Metal.GOLD.getName(), metal.name());
    }

    @Test
    void purchaseDate() {
        Assertions.assertEquals(LocalDate.of(2024, 3, 8), metal.purchaseDate());
    }

    @Test
    void weight() {
        Assertions.assertEquals(31.1, metal.weight());
    }

    @Test
    void pricePerUnit() {
        Assertions.assertEquals(3500, metal.pricePerUnit());
    }
}
