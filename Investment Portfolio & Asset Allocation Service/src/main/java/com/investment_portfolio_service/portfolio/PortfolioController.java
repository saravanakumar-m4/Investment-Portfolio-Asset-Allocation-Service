package com.investment_portfolio_service.portfolio;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/portfolios")
@Tag(name = "Portfolio APIs", description = "Operations related to users portfolio")
public class PortfolioController {

	private final PortfolioService portfolioService;

	public PortfolioController(PortfolioService portfolioService) {
		this.portfolioService = portfolioService;
	}

	@Operation(summary = "Create Portfolio", description = "Create Portfolio by user ID")
	@PostMapping("/{userId}")
	public Portfolio create(@PathVariable Long userId) {
		return portfolioService.createPortfolio(userId);
	}

	@Operation(summary = "Create Portfolio with asset", description = "Create Portfolio by user ID with invested amount and asset")
	@PostMapping("/{portfolioId}/assets/{assetId}")
	public Portfolio addAsset(@PathVariable Long portfolioId, @PathVariable Long assetId, @RequestParam double amount) {
		return portfolioService.addAsset(portfolioId, assetId, amount);
	}

	@PostMapping("/{userId}/allocate")
	public Portfolio createWithAllocation(@PathVariable Long userId, @RequestParam double amount) {
		return portfolioService.createPortfolioWithAllocation(userId, amount);
	}

	@GetMapping("/{userId}")
	public Optional<Portfolio> userPortfolio(@PathVariable Long userId) {
		return portfolioService.getPortfolio(userId);
	}

}
