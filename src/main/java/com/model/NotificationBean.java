package com.model;

public class NotificationBean {

	private int bus_no;
	private String current;
	private String next;
	private int size;
	public NotificationBean() {
		super();
	}

	public NotificationBean(int bus_no, String next) {
		super();
		this.bus_no = bus_no;
		
		this.next = next;
	}

	public int getBus_no() {
		return bus_no;
	}

	public void setBus_no(int bus_no) {
		this.bus_no = bus_no;
	}

	public String getCurrent() {
		return current;
	}

	public void setCurrent(String current) {
		this.current = current;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "NotificationBean [bus_no=" + bus_no + ", current=" + current + ", next=" + next + "]";
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
