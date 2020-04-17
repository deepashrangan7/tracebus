package com.logic;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Service;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

@Service
public class QRGenerator {

	public void genrateQRTicket(Integer tid,String user) {
		String url="http://192.168.43.36:8089/tickets?tid="+tid;
		String file="E:\\QR\\"+user+""+tid+".png";
		ByteArrayOutputStream bout =
	                QRCode.from(url)
	                        .withSize(250, 250)
	                        .to(ImageType.PNG)
	                        .stream();

	        try {
	            OutputStream out = new FileOutputStream(file);
	            bout.writeTo(out);
	            out.flush();
	            out.close();

	        } catch (FileNotFoundException e){
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
