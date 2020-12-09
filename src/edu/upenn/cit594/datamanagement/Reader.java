package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.data.Parking;
import edu.upenn.cit594.data.Properties;
import java.util.List;
import java.util.Map;

public interface Reader {

	public List<Properties> getAllPropertyInfo();

	public List<Parking> getAllParkingInfo();

	public Map<String, Integer> getPopulationByZipcode();

}
