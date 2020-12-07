package edu.upenn.cit594.data;

public class Population {

	private final String zipCode;
	private final int totalPopulation;

	public Population(String zipCode, int totalPopulation) {
		this.zipCode = zipCode;
		this.totalPopulation = totalPopulation;
	}

	public String getZipcode() {
		return zipCode;
	}

	public int getPopulation() {
		return totalPopulation;
	}

}
