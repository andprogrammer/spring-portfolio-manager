package com.portfolio.springPortfolioManager.repository;

import com.portfolio.springPortfolioManager.model.impl.Asset;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AssetRepository {

    private final List<Asset> assets = new ArrayList<>();

    public void addAsset(Asset asset) {
        if (asset != null) {
            assets.add(asset);
        }
    }

    public double totalPurchaseValue() {
        return assets.stream()
                .mapToDouble(Asset::purchaseValue)
                .sum();
    }

    public double totalProfit() {
        return assets.stream()
                .mapToDouble(Asset::profit)// ToDo distinguish currency PLN EURO USD...
                .sum();
    }

    public List<Asset> findAll() {
        return List.copyOf(assets);
    }

    public void report() {
        assets.forEach(asset -> {
            System.out.printf(asset.name(), asset.purchaseDate(), asset.purchaseValue(), asset.profit());
        });
    }

    public void showAssets() {
        if (assets.isEmpty()) {
            System.out.println("No assets");
        } else {
            assets.forEach(System.out::println);
        }
    }
}
