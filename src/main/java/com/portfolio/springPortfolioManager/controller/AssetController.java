package com.portfolio.springPortfolioManager.controller;

import com.portfolio.springPortfolioManager.model.impl.Asset;
import com.portfolio.springPortfolioManager.service.AssetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetController {

    private final AssetService service;

    public AssetController(AssetService service) {
        this.service = service;
    }

    @GetMapping
    public List<Asset> getAllAssets() {
        return service.getAllAssets();
    }

    @PostMapping
    public void addAsset(@RequestBody Asset asset) {
        service.addAsset(asset);
    }
}
