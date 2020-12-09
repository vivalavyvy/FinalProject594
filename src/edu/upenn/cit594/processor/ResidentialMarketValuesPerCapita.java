package edu.upenn.cit594.processor;

import java.util.List;
import java.util.Map;

import edu.upenn.cit594.data.Properties;
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
	private int findPopulationForZipCode(String zipCode,Map<String, Integer> populationByZipCode) {
		
		
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
	private int findSumOfMarketValueForZipCode(String zipCode, List<Properties> propertiesList) {
		
		int sumOfMarketValue = 0;
		
		for (Properties p: propertiesList) {
			
			if(p.getZipCode().equals(zipCode)) {
				
				sumOfMarketValue += Integer.parseInt(p.getMarketValue());
			}
			
		}
		
		return sumOfMarketValue;
		
	}
	
	/**
	 * @author stevebaca
	 * @since 12/9
	 * @return
	 */
	public double calculateTotalResidentialMarketValuePerCapita(String zipCode, List<Properties> propertiesList, Map<String, Integer> populationByZipCode) {
		
		double totalResidentialMarketValuePerCapita = findSumOfMarketValueForZipCode(zipCode, propertiesList)/findPopulationForZipCode(zipCode, populationByZipCode);
		
		
		return totalResidentialMarketValuePerCapita;
	}
	
	
	
	

}
