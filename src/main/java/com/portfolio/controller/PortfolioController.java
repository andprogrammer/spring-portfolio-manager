package com.portfolio.controller;

import com.portfolio.asset.core.Asset;
import com.portfolio.manager.dto.PortfolioLine;
import com.portfolio.service.PortfolioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class PortfolioController {

    private final PortfolioService service;

    public PortfolioController(PortfolioService service) {
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

    @GetMapping("/report")
    public List<PortfolioLine> getPortfolioReport() {
        return service.getPortfolioReport();
    }
}
