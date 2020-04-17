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
//		if(e-f>0)
//			x=(e-f)*5;
//		else {
//			int times=5-e;
//			times+=4-e;
//			x=times*x;
//		}
		return x;

	}
}




//public void gen(String name) throws IOException
//{
//	Date d = new Date();
//	int tid = 0;
//	String datet = d.getDate() + "/ 2"  + "/2020" + " " + d.getHours() + ":" + d.getMinutes() + ":"
//			+ d.getSeconds();
//	String details = "\n\n		This is Your Ticket " + name + "\n		Your Ticket Id is 0 \n" 
//			+ "\n		Bus No is  1 \n date is "+datet ;
//
//	ByteArrayOutputStream out1 = QRCode.from(details).to(ImageType.JPG).stream();
//	String path = "E:\\QR\\";
//	path += name + "" + tid + ".png";
//	java.io.File fs = new java.io.File(path);
//	FileOutputStream f = new FileOutputStream(fs);
//	f.write(out1.toByteArray());
//	f.flush();
//	System.out.println("\n\n!!!!!!QR SUCCESFULLY generated!!!!!!");
//	
//	
////res.setContentType("text/html"); 
////
//	}
