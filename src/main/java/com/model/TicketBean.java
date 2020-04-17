package com.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class TicketBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;
	
	private String uid;
	
	private String busfrom;
	
	public String getBusfrom() {
		return busfrom;
	}
	public void setBusfrom(String busfrom) {
		this.busfrom = busfrom;
	}
	public String getBusto() {
		return busto;
	}
	public void setBusto(String busto) {
		this.busto = busto;
	}
	private String busto;
	private Date date;
	private String active;
	private int count;
	private double cost;
	private Integer bus_no;
	public Integer getBus_no() {
		return bus_no;
	}
	public void setBus_no(Integer bus_no) {
		this.bus_no = bus_no;
	}
	public int getTid() {
		return tid;
	}
	
	@Override
	public String toString() {
		return "TicketBean [tid=" + tid + ", uid=" + uid + ", busfrom=" + busfrom + ", busto=" + busto + ", date="
				+  ", active=" + active + ", count=" + count + ", cost=" + cost + "]";
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
