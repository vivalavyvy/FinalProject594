package edu.upenn.cit594.processor;

import java.util.HashMap;

import edu.upenn.cit594.datamanagement.csvReader;

public class ResidentialMarketValuesPerCapita {
	
	public String zipCode;
	public csvReader csvReader;
	
	public ResidentialMarketValuesPerCapita(String zipCode) {
		this.zipCode = zipCode;
		csvReader = new csvReader(properties, parking, population);
	}
	
	
	/**
	 * @author stevebaca
	 * @since 12/9
	 * @param zipCode
	 */
	private int findPopulationForZipCode(String zipCode) {
		
		HashMap<String, Integer> populationByZipCode = csvReader.getPopulationByZipcode();
		
		for (String zipCodeIterator : populationByZipCode.keySet()) {
			
			if(zipCodeIterator.equals(zipCode)) {
				
				return populationByZipCode.get(zipCode);
				
			}
			
		}
		
		
		return 0;
	}
	
	/**
	 * @author stevebaca
	 * @since 12/9
	 * @param zipCode
	 * @return
	 */
	private int findSumOfMarketValueForZipCode(String zipCode) {
		
		
		
	}
	
	
	
	

}
