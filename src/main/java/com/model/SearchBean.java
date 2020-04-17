package com.model;

import org.springframework.stereotype.Component;

@Component
public class SearchBean {

	private String boarding;
	private String destination;

	public String getBoarding() {
		return boarding;
	}

	public void setBoarding(String boarding) {
		this.boarding = boarding;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "SearchBean [boarding=" + boarding + ", destination=" + destination + "]";
	}
}
