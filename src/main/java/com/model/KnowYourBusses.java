package com.model;

public class KnowYourBusses {

	public KnowYourBusses(int bus_no, String currentLocation) {
		super();
		this.bus_no = bus_no;
		this.currentLocation = currentLocation;
	}

	public KnowYourBusses() {
		super();
	}

	private int bus_no;
	private String currentLocation;
	private int stops;

	public int getBus_no() {
		return bus_no;
	}

	public void setBus_no(int bus_no) {
		this.bus_no = bus_no;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public int getStops() {
		return stops;
	}

	public void setStops(int stops) {
		this.stops = stops;
	}

	@Override
	public String toString() {
		return "KnowYourBusses [bus_no=" + bus_no + ", currentLocation=" + currentLocation + ", stops=" + stops + "]";
	}

}
