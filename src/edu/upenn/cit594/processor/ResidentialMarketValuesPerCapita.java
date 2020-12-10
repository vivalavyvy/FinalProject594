package edu.upenn.cit594.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.upenn.cit594.data.Properties;

public class ResidentialMarketValuesPerCapita {

	private static // memoization
	HashMap<String, Double> memoizationTracker = new HashMap<String, Double>();
	
	

	/**
	 * @author stevebaca
	 * @since 12/9
	 * @param zipCode
	 */
	private static int findPopulationForZipCode(String zipCode, Map<String, Integer> populationByZipCode) {

		for (String zipCodeIterator : populationByZipCode.keySet()) {

			if (zipCodeIterator.equals(zipCode)) {

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
	private static int findSumOfMarketValueForZipCode(String zipCode, List<Properties> propertiesList) {

		int sumOfMarketValue = 0;

		for (Properties p : propertiesList) {

			if (p.getZipCode().equals(zipCode)) {

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
	public static double calculateTotalResidentialMarketValuePerCapita(String zipCode, List<Properties> propertiesList,
			Map<String, Integer> populationByZipCode) {

		//memoization
		if (memoizationTracker.containsValue(zipCode)) {
			return memoizationTracker.get(zipCode);
		}

		double totalResidentialMarketValuePerCapita = findSumOfMarketValueForZipCode(zipCode, propertiesList)
				/ findPopulationForZipCode(zipCode, populationByZipCode);

		memoizationTracker.put(zipCode, totalResidentialMarketValuePerCapita);

		return totalResidentialMarketValuePerCapita;
	}

}
