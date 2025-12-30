package com.portfolio.springPortfolioManager.model.asset.monetaryUnit;

public enum CryptoCurrency implements MonetaryUnit {

    BTC("Bitcoin", "BTC", "₿"),
    ETH("Ethereum", "ETH", "Ξ"),
    USDT("Tether", "USDT", "₮"),
    BNB("Binance Coin", "BNB", "BNB");

    private final String name;
    private final String code;
    private final String symbol;

    CryptoCurrency(String name, String code, String symbol) {
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

