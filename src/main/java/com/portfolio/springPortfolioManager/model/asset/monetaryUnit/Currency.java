package com.portfolio.springPortfolioManager.model.asset.monetaryUnit;

public enum Currency implements MonetaryUnit {

    PLN("Polish Zloty", "PLN", "zł"),
    EUR("Euro", "EUR", "€"),
    USD("US Dollar", "USD", "$"),
    CHF("Swiss Franc", "CHF", "CHF");

    private final String name;
    private final String code;
    private final String symbol;

    Currency(String name, String code, String symbol) {
        this.name = name;
        this.code = code;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return name + " " + code + " " + symbol;
    }
}
