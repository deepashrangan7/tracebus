package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notify {

	private Integer bus_no;
	private String pickup;
	private String droping;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String email;
	private String isNotified = "no";

	public Notify() {
		super();
	}

	public Integer getBus_no() {
		return bus_no;
	}

	public void setBus_no(Integer bus_no) {
		this.bus_no = bus_no;
	}

	public String getPickup() {
		return pickup;
	}

	public void setPickup(String pickup) {
		this.pickup = pickup;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String isNotified() {
		return isNotified;
	}

	public void setNotified(String isNotified) {
		this.isNotified = isNotified;
	}

	@Override
	public String toString() {
		return "Notify [bus_no=" + bus_no + ", pickup=" + pickup + ", drop=" + droping + ", id=" + id + ", email=" + email
				+ ", isNotified=" + isNotified + "]";
	}

	public String getDroping() {
		return droping;
	}

	public void setDroping(String droping) {
		this.droping = droping;
	}

}
