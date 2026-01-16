package com.portfolio.asset.core;

public enum AssetType {

    BOND("Bond"),
    CASH("Cash"),
    CRYPTO("Cryptocurrency"),
    DEPOSIT("Deposit"),
    FUND("Fund"),
    METAL("Metal"),
    SAVINGS_ACCOUNT("Savings Account"),
    STOCK("Stock");

    private final String displayName;

    AssetType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
