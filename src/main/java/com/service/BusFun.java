package com.service;

import org.springframework.stereotype.Component;

import com.model.BusBean;

@Component
public class BusFun {

	public double calculateCharge(BusBean obj, String from, String to) {
		double x = 0;
		int f,e;
		if(obj.getStop1().equals(from))
			f=1;
		else if(obj.getStop2().equals(from))
			f=2;
		else if(obj.getStop3().equals(from))
			f=3;
		else if(obj.getStop4().equals(from))
			f=4;
		else 
			f=5;
		
		if(obj.getStop1().equals(to))
			e=1;
		else if(obj.getStop2().equals(to))
			e=2;
		else if(obj.getStop3().equals(to))
			e=3;
		else if(obj.getStop4().equals(to))
			e=4;
		else 
			e=5;
		
//		System.out.println("f is "+f+" e is "+e);
		
		if(e-f>0)
			x=(e-f)*5;
		else
			x=(f-e)*5;
		return x;

	}
}





