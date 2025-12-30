package com.portfolio.springPortfolioManager.service;

import com.portfolio.springPortfolioManager.model.asset.impl.Asset;
import com.portfolio.springPortfolioManager.repository.AssetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {

    private final AssetRepository repository;

    public AssetService(AssetRepository repository) {
        this.repository = repository;
    }

    public List<Asset> getAllAssets() {
        return repository.findAll();
    }

    public void addAsset(Asset asset) {
        repository.addAsset(asset);
    }
}
