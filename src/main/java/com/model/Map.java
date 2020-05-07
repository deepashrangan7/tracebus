package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Map {

	@Id
	private String stop;
	private Double lat;
	private Double lo;

	public String getStop() {
		return stop;
	}

	public void setStop(String stop) {
		this.stop = stop;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLo() {
		return lo;
	}

	public void setLo(Double lo) {
		this.lo = lo;
	}

	public Map(String stop, Double lat, Double lo) {
		super();
		this.stop = stop;
		this.lat = lat;
		this.lo = lo;
	}

	public Map() {
		super();
	}

	
}
