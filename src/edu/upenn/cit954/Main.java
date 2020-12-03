package edu.upenn.cit954;

import edu.upenn.cit594.ui.GUI;

public class Main {

	/**
	 * Runtime args are as follows arg[0] format of the parking violations input
	 * file, either csv or json args[1] the name of the parking violations input
	 * file args[2] The name of the property values input file args[3] The name of
	 * the population input file args[4] The name fo the log file
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		GUI gui = new GUI();
		

		//showing what the different args are that has been passed to main 
		for (int i = 0; i < args.length; i++) {
			System.out.println("arg" + "[" + i + "]" + " " + args[i] + "\n");
		}

		if (args.length < 5 || args.length > 5) {
			System.err.println("Wrong number of arguments");
			System.exit(-1);
		}
		
		if (!(args[0].equalsIgnoreCase("csv") || args[0].equalsIgnoreCase("json"))) {
			System.err.println("Please change the first argument to either csv or json");
			System.exit(-1);
		}
		
		

	}

}
