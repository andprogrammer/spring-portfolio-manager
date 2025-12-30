package com.portfolio.springPortfolioManager.model.asset.monetaryUnit;

public enum Metal implements MonetaryUnit {

    GOLD("Gold", "XAU", "Au"),
    SILVER("Silver", "XAG", "Ag"),
    PLATINUM("Platinum", "XPT", "Pt"),
    PALLADIUM("Palladium", "XPD", "Pd");

    private final String name;
    private final String code;
    private final String symbol;

    Metal(String name, String code, String symbol) {
        this.name = name;
        this.code = code;
        this.symbol = symbol;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
}
