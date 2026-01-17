package com.portfolio.asset.model.builders;

import com.portfolio.asset.core.Money;
import com.portfolio.asset.model.Bond;
import com.portfolio.asset.unit.Currency;

import java.time.LocalDate;

public class BondBuilder {

    private String name = "Bond";
    private Money purchaseValue = new Money(1_000, Currency.PLN);
    private LocalDate purchaseDate = LocalDate.now();
    private double annualInterestRate = 5.0;
    private int durationMonths = 12;

    public BondBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public BondBuilder withPurchaseValue(Money purchaseValue) {
        this.purchaseValue = purchaseValue;
        return this;
    }

    public BondBuilder withPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
        return this;
    }

    public BondBuilder withAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
        return this;
    }

    public BondBuilder withDurationMonths(int durationMonths) {
        this.durationMonths = durationMonths;
        return this;
    }

    public Bond build() {
        return new Bond(
                name,
                purchaseValue,
                purchaseDate,
                annualInterestRate,
                durationMonths
        );
    }
}
