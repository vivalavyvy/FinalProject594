package edu.upenn.cit594.logging;

import java.io.File;
import java.io.PrintWriter;

public class Logger {

	private String fileName;
	private PrintWriter out;

	// 1. private constuctor
	private Logger(String fileName) {
		// TODO Auto-generated constructor stub
		this.fileName = fileName;

		try {

			PrintWriter writer = new PrintWriter(fileName);
			writer.print("");
			writer.close();
			out = new PrintWriter(new File(fileName));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author stevebaca
	 * @since 12/08
	 * @param Args
	 */
	public void writeRunTimeArgs(String[] args) {

		for (int i = 0; i < args.length; i++) {

			out.println(System.currentTimeMillis() + " " + args[i]);
			out.flush();

		}
	}

	/**
	 * @author stevebaca
	 * @since 12/08
	 * @param test
	 */
	public void openedForReading(String fileName) {

		out.println(System.currentTimeMillis() + " " + fileName);
		out.flush();
	}

	// 2. singleton instance
	// I was told by a TA to hard code the name of the logger file into this class
	private static Logger logger = null;

	// 3. singleton accessor method

	public static Logger getInstance(String fileName) {
		if (logger == null) {
			logger = new Logger(fileName);
		}

		return logger;
	}

}
