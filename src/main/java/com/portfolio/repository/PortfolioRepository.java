package com.portfolio.repository;

import com.portfolio.asset.core.Asset;
import com.portfolio.asset.core.Money;
import com.portfolio.asset.unit.MonetaryUnit;
import com.portfolio.asset.core.ValuableAsset;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PortfolioRepository {

    private final List<Asset> assets = new ArrayList<>();

    public void add(Asset asset) {
        if (asset != null) {
            assets.add(asset);
        }
    }

    public List<Asset> findAll() {
        return List.copyOf(assets);
    }

    public Map<MonetaryUnit, Double> totalPurchaseValueByCurrency() {
        return assets.stream()
                .map(Asset::purchaseValue)
                .collect(Collectors.groupingBy(
                        Money::currency,
                        Collectors.summingDouble(Money::amount)
                ));
    }

    public Map<MonetaryUnit, Double> totalProfitByCurrency() {
        return assets.stream()
                .filter(a -> a instanceof ValuableAsset)
                .map(a -> ((ValuableAsset) a).profit())
                .collect(Collectors.groupingBy(
                        Money::currency,
                        Collectors.summingDouble(Money::amount)
                ));
    }
}
