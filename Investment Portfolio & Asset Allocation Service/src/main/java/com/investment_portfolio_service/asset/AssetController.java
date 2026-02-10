package com.investment_portfolio_service.asset;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/assets")
public class AssetController {

	private AssetService assetService;

	public AssetController(AssetService assetService) {
		super();
		this.assetService = assetService;
	}

	@PostMapping
	public Asset create(@RequestBody Asset asset) {
		return assetService.save(asset);
	}

	@GetMapping
	public List<Asset> list() {
		return assetService.findAll();
	}

}