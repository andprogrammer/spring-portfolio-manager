package com.portfolio.service;

import com.portfolio.asset.core.Asset;
import com.portfolio.asset.core.ValuableAsset;
import com.portfolio.manager.dto.PortfolioLine;
import com.portfolio.repository.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PortfolioService {

    private final PortfolioRepository repository;

    public PortfolioService(PortfolioRepository repository) {
        this.repository = repository;
    }

    public List<Asset> getAllAssets() {
        return repository.findAll();
    }

    public void addAsset(Asset asset) {
        repository.add(asset);
    }

    public List<PortfolioLine> getPortfolioReport() {
        return repository.findAll()
                .stream()
                .map(a -> {
                    var profit = (a instanceof ValuableAsset va) ? va.profit() : null;
                    return new PortfolioLine(
                            a.type().getDisplayName(),
                            a.name(),
                            a.purchaseDate(),
                            a.purchaseValue(),
                            profit
                    );
                })
                .collect(Collectors.toList());
    }
}
