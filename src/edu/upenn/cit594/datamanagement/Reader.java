package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.data.Population;
import edu.upenn.cit594.data.Properties;
import java.util.List;

public interface Reader {

	public List<Properties> getAllPropertyInfo();

	public List<Population> getPopulationByZipcode();

}
