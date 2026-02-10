package com.investment_portfolio_service.asset;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Asset {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

// EQUITY, DEBT, GOLD, CASH
	private String type;

	private double expectedReturn;

	private double riskFactor;

}
