package com.model;

import org.springframework.stereotype.Component;

@Component
public class BusSpecificBean {

	private int bus_no;
	private String busStop1;
	private String busStop2;
	private String busStop3;
	private String busStop4;
	private String busStop5;

	private String time1;
	private String time2;
	private String time3;
	private String time4;
	private String time5;

	private String date1;
	private String date2;
	private String date3;
	private String date4;
	private String date5;

	private String loc;

	public int getBus_no() {
		return bus_no;
	}

	public void setBus_no(int bus_no) {
		this.bus_no = bus_no;
	}

	public String getBusStop1() {
		return busStop1;
	}

	public void setBusStop1(String busStop1) {
		this.busStop1 = busStop1;
	}

	public String getBusStop2() {
		return busStop2;
	}

	public void setBusStop2(String busStop2) {
		this.busStop2 = busStop2;
	}

	public String getBusStop3() {
		return busStop3;
	}

	public void setBusStop3(String busStop3) {
		this.busStop3 = busStop3;
	}

	public String getBusStop4() {
		return busStop4;
	}

	public void setBusStop4(String busStop4) {
		this.busStop4 = busStop4;
	}

	public String getBusStop5() {
		return busStop5;
	}

	public void setBusStop5(String busStop5) {
		this.busStop5 = busStop5;
	}

	public String getTime1() {
		return time1;
	}

	public void setTime1(String time1) {
		this.time1 = time1;
	}

	public String getTime2() {
		return time2;
	}

	public void setTime2(String time2) {
		this.time2 = time2;
	}

	public String getTime3() {
		return time3;
	}

	public void setTime3(String time3) {
		this.time3 = time3;
	}

	public String getTime4() {
		return time4;
	}

	public void setTime4(String time4) {
		this.time4 = time4;
	}

	public String getTime5() {
		return time5;
	}

	public void setTime5(String time5) {
		this.time5 = time5;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public String getDate3() {
		return date3;
	}

	public void setDate3(String date3) {
		this.date3 = date3;
	}

	public String getDate4() {
		return date4;
	}

	public void setDate4(String date4) {
		this.date4 = date4;
	}

	public String getDate5() {
		return date5;
	}

	public void setDate5(String date5) {
		this.date5 = date5;
	}

	@Override
	public String toString() {
		return "BusSpecificBean [date1=" + date1 + ", date2=" + date2 + ", date3=" + date3 + ", date4=" + date4
				+ ", date5=" + date5 + "]";
	}

}
