package edu.upenn.cit594.data;

public class Properties {

	private final String marketValue;
	private final String totalLivableArea;
	private final String zipCode;

	public Properties(String marketValue, String totalLivableArea, String zipCode) {
		this.marketValue = marketValue;
		this.totalLivableArea = totalLivableArea;
		this.zipCode = zipCode;
	}

	public String getMarketValue() {
		return marketValue;
	}

	public String getTotalLivableArea() {
		return totalLivableArea;
	}

	public String getZipCode() {
		return zipCode;
	}
}
