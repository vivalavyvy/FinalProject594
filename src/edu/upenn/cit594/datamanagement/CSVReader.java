package edu.upenn.cit594.datamanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import edu.upenn.cit594.data.Parking;
import edu.upenn.cit594.data.Population;
import edu.upenn.cit594.data.Properties;

public class csvReader implements Reader {
	
	protected String properties;
	protected String population;
	protected String parking;
	
	public csvReader (String properties, String parking, String population) {
		this.properties = properties;
		this.parking = parking;
		this.population = population;
	}
	
	public List<Parking> getAllParkingInfo(){
		Scanner input = null;
		List<Parking> parkingList = new ArrayList<Parking>();
		
		try {
			input = new Scanner (new File ("parking.csv"));
			//int count = 0;
			while (input.hasNextLine()) {
				String lineOfParking = input.nextLine();
				String testArray[]= lineOfParking.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); //regex used to split the string by commas not in quotation marks
				
				String parkingFineString = testArray[1];
				int parkingFine = Integer.parseInt(parkingFineString);
				//System.out.println(parkingFine);
				
				String licensePlateState = testArray[4];
				//System.out.println(licensePlateState);
				
				String zipcodeString = "";
				
				if (testArray.length == 7) {
					zipcodeString = testArray[6];
				}
				//System.out.println(zipcodeString);
				
				parkingList.add(new Parking(zipcodeString, parkingFine, licensePlateState));
				//System.out.println(parkingList.get(count));
				//count++;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			input.close();
			
		}
		return parkingList;
}
	
	
	
	public List<Properties> getAllPropertyInfo(){
		
		Scanner input = null;
		List<Properties> propertiesList = new ArrayList<Properties>();
		
		try {
			
			// read in properties.csv file
			input = new Scanner (new File("properties.csv")); // CAUTION CHANGE THIS TO THE VARIABLE NAME WHEN WE CONNECT IT TO MAIN CLASS, APPLY ELSEWHERE TOO
			
			// read in header files and split into tokens
			String headersOfCSV = input.nextLine();
			String[] headerColumns = headersOfCSV.split(",");
			
			// put header file into ArrayList so we can get the index of the value quickly
			List<String> headerInList = new ArrayList<String>();
			headerInList = Arrays.asList(headerColumns);
		
			// return indices of our desired values from the header file
			int marketValueIndex = headerInList.indexOf("market_value");
			int totalLivableAreaIndex = headerInList.indexOf("total_livable_area");
			int zipcodeIndex = headerInList.indexOf("zip_code");
			
			// counter to be used in while loop below as a sanity check so we know where the rows have different lengths
			int count = 0;
			
			List<Integer> countErrors = new ArrayList<Integer>();
			
			while (input.hasNextLine()) {
				String lineOfProperties = input.nextLine();
				String testArray[]= lineOfProperties.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); //regex used to split the string by commas not in quotation marks
				
				// counting all the indices where the size doesn't match, not always false, sometimes missing zipcode or something which doesn't affect our output
				// this is more as a sanity check
				if (testArray.length != headerInList.size()) {
					//System.out.println("Does not match length at index "+ count);
					countErrors.add(count);
				}
				
				// storing the values from the testArray
				String marketValue = testArray[marketValueIndex];
				String totalLivableArea = testArray[totalLivableAreaIndex];
				String zipCode = testArray[zipcodeIndex];
				zipCode = zipCode.substring(0, Math.min(zipCode.length(), 5));
				
				// adding the stored values into the new Properties object for each row
				propertiesList.add(new Properties(marketValue, totalLivableArea, zipCode));
				count++;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			input.close();
			
		}
		
		return propertiesList;

	} 

	
	public Map<String, Integer> getPopulationByZipcode() {
		
		Map <String, Integer> populationByZipCode = new HashMap<String, Integer>();
		
		//List<Population> populationByZipcode = new ArrayList<Population>();
		
		
		Scanner input = null;
		
		try {
			input = new Scanner (new File(population));
			
			while (input.hasNextLine()) {
				String s = input.nextLine();
				String testArray[] = s.split("\\s");
				
				String zipcodeString = testArray[0];
			
				String populationString = testArray[1];
				int populationInteger = Integer.parseInt(populationString);
				
				populationByZipCode.put(zipcodeString, populationInteger);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			input.close();
		}	
		
		return populationByZipCode;
		
	}
		
	
	
	
}
