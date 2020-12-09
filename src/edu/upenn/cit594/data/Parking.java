package edu.upenn.cit594.data;

public class Parking {

	private final int parkingFine;
	private final String zipcode;
	private final String licensePlateState;

	public Parking(String zipcode, int parkingFine, String licensePlateState) {
		this.parkingFine = parkingFine;
		this.zipcode = zipcode;
		this.licensePlateState = licensePlateState;
	}

	public int getParkingFine() {
		return parkingFine;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getLicensePlateState() {
		return licensePlateState;
	}

}
