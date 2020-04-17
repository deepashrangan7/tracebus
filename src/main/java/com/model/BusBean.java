package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bus")
public class BusBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bus_no;
	private String stop1;
	private String stop2;
	private String stop3;
	private String stop4;
	private String stop5;

	private String loc;

	private String direction;

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getBus_no() {
		return bus_no;
	}

	public void setBus_no(int bus_no) {
		this.bus_no = bus_no;
	}

	public String getStop1() {
		return stop1;
	}

	public void setStop1(String stop1) {
		this.stop1 = stop1;
	}

	public String getStop2() {
		return stop2;
	}

	public void setStop2(String stop2) {
		this.stop2 = stop2;
	}

	public String getStop3() {
		return stop3;
	}

	public void setStop3(String stop3) {
		this.stop3 = stop3;
	}

	public String getStop4() {
		return stop4;
	}

	public void setStop4(String stop4) {
		this.stop4 = stop4;
	}

	public String getStop5() {
		return stop5;
	}

	public void setStop5(String stop5) {
		this.stop5 = stop5;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "BusBean [bus_no=" + bus_no + ", stop1=" + stop1 + ", stop2=" + stop2 + ", stop3=" + stop3 + ", stop4="
				+ stop4 + ", stop5=" + stop5 + ", loc=" + loc + "]";
	}

}
