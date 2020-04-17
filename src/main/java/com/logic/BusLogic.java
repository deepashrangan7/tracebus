package com.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.BusBean;
import com.model.BusSpecificBean;
import com.model.FareBean;
import com.service.BusDao;

@Service
public class BusLogic {
	@Autowired
	private BusDao busDao;

	public List<FareBean> calucateFare(String pickup, String drop) {
		List<FareBean> obj = new ArrayList<>();
		List<BusBean> bb = busDao.KnowYourBus(pickup, drop);
		for (BusBean b : bb) {
			obj.add(new FareBean());
			obj.get(obj.size() - 1).setBus_no(b.getBus_no());
			obj.get(obj.size() - 1).setCurrentLocation(b.getLoc());
			obj.get(obj.size() - 1).setFare(calc(b, pickup, drop));
		}
		return obj;
	}

	public double calc(BusBean b, String pickup, String drop) {
		double amnt = 0.0;
		if(b.getStop1().equals(pickup)) {
			if(b.getDirection().equals("up")) {
				if(b.getStop2().equals(drop))
					amnt=8;
				else if(b.getStop3().equals(drop))
					amnt=15.0;
				else if(b.getStop4().equals(drop))
					amnt=21.0;
				else if(b.getStop5().equals(drop))
					amnt=26.0;
			}
			
		}else if(b.getStop2().equals(pickup)) {
			if(b.getDirection().equals("up")) {
				if(b.getStop3().equals(drop))
					amnt=8;
				else if(b.getStop4().equals(drop))
					amnt=15.0;
				else if(b.getStop5().equals(drop))
					amnt=21.0;
				else if(b.getStop1().equals(drop))
					amnt=26+21;
			}else {
				if(b.getStop3().equals(drop))
					amnt=21;
				else if(b.getStop4().equals(drop))
					amnt=26.0;
				else if(b.getStop5().equals(drop))
					amnt=31.0;
				else if(b.getStop1().equals(drop))
					amnt=8;
				
			}
			
		}else if(b.getStop3().equals(pickup)) {
			if(b.getDirection().equals("up")) {
				if(b.getStop2().equals(drop))
					amnt=15+15+8;
				else if(b.getStop4().equals(drop))
					amnt=8.0;
				else if(b.getStop5().equals(drop))
					amnt=15.0;
				else if(b.getStop1().equals(drop))
					amnt=15+15+13;
			}else {
				if(b.getStop2().equals(drop))
					amnt=8;
				else if(b.getStop4().equals(drop))
					amnt=14+14+7;
				else if(b.getStop5().equals(drop))
					amnt=39;
				else if(b.getStop1().equals(drop))
					amnt=14;
				
			}
		}else if(b.getStop4().equals(pickup)) {
			if(b.getDirection().equals("up")) {
				if(b.getStop2().equals(drop))
					amnt=9+20;
				else if(b.getStop3().equals(drop))
					amnt=9+14;
				else if(b.getStop5().equals(drop))
					amnt=9;
				else if(b.getStop1().equals(drop))
					amnt=34;
			}else {
				if(b.getStop2().equals(drop))
					amnt=17;
				else if(b.getStop3().equals(drop))
					amnt=9;
				else if(b.getStop5().equals(drop))
					amnt=38;
				else if(b.getStop1().equals(drop))
					amnt=21;
				
			}
		}else if(b.getStop5().equals(pickup)) {
				if(b.getStop2().equals(drop))
					amnt=19;
				else if(b.getStop4().equals(drop))
					amnt=7;
				else if(b.getStop3().equals(drop))
					amnt=13;
				else if(b.getStop1().equals(drop))
					amnt=24;
				
			
		}
		return amnt;
	}

	public BusSpecificBean setTime(BusSpecificBean bsb, String dir) {
		Date d = new Date();

		String s = "";
		if (bsb.getTime1() == "arrived") {

			Date d1 = new Date(System.currentTimeMillis() - (2 * 60 * 1000));
			s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
			bsb.setDate1(s);
			d1 = new Date(System.currentTimeMillis() + (17 * 60 * 1000));
			s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
			bsb.setDate2(s);
			d1 = new Date(System.currentTimeMillis() + (38 * 60 * 1000));
			s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
			bsb.setDate3(s);
			d1 = new Date(System.currentTimeMillis() + (49 * 60 * 1000));
			s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
			bsb.setDate4(s);
			d1 = new Date(System.currentTimeMillis() + (63 * 60 * 1000));
			s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
			bsb.setDate5(s);

		} else if (bsb.getTime2() == "arrived") {

			Date d1 = new Date(System.currentTimeMillis() - (2 * 60 * 1000));
			if (dir.equals("up")) {

				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate2(s);
				d1 = new Date(System.currentTimeMillis() - (23 * 60 * 1000));
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate1(s);

				d1 = new Date(System.currentTimeMillis() + (17 * 60 * 1000));
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate3(s);
				d1 = new Date(System.currentTimeMillis() + (38 * 60 * 1000));
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate4(s);
				d1 = new Date(System.currentTimeMillis() + (49 * 60 * 1000));
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate5(s);

			} else {
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate2(s);
				d1 = new Date(System.currentTimeMillis() - (23 * 60 * 1000));
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate3(s);

				d1 = new Date(System.currentTimeMillis() + (17 * 60 * 1000));
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate1(s);
				d1 = new Date(System.currentTimeMillis() - (38 * 60 * 1000));
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate4(s);
				d1 = new Date(System.currentTimeMillis() - (49 * 60 * 1000));
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate5(s);

			}
		} else if (bsb.getTime3() == "arrived") {

			Date d1 = new Date(System.currentTimeMillis() - (2 * 60 * 1000));
			if (dir.equals("up")) {

				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate3(s);
				d1 = new Date(System.currentTimeMillis() + (17 * 60 * 1000));
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate4(s);
				d1 = new Date(System.currentTimeMillis() + (38 * 60 * 1000));
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate5(s);
				d1 = new Date(System.currentTimeMillis() - (27 * 60 * 1000));
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate2(s);
				d1 = new Date(System.currentTimeMillis() - (39 * 60 * 1000));
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate1(s);
			} else {
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate3(s);
				d1 = new Date(System.currentTimeMillis() + (17 * 60 * 1000));
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate2(s);
				d1 = new Date(System.currentTimeMillis() + (38 * 60 * 1000));
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate1(s);
				d1 = new Date(System.currentTimeMillis() - (27 * 60 * 1000));
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate4(s);
				d1 = new Date(System.currentTimeMillis() - (39 * 60 * 1000));
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate5(s);

			}

		} else if (bsb.getTime4() == "arrived") {

			Date d1 = new Date(System.currentTimeMillis() - (2 * 60 * 1000));
			if (dir.equals("up")) {
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate4(s);
				d1 = new Date(System.currentTimeMillis() + (17 * 60 * 1000));
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate5(s);
				d1 = new Date(System.currentTimeMillis() - (18 * 60 * 1000));
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate3(s);
				d1 = new Date(System.currentTimeMillis() - (39 * 60 * 1000));
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate2(s);
				d1 = new Date(System.currentTimeMillis() - (52 * 60 * 1000));
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate1(s);

			} else {
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate4(s);
				d1 = new Date(System.currentTimeMillis() + (13 * 60 * 1000));
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate3(s);
				d1 = new Date(System.currentTimeMillis() - (18 * 60 * 1000));
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate5(s);
				d1 = new Date(System.currentTimeMillis() + (22 * 60 * 1000));
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate2(s);
				d1 = new Date(System.currentTimeMillis() + (32 * 60 * 1000));
				s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
				bsb.setDate1(s);
			}
		} else if (bsb.getTime5() == "arrived") {

			Date d1 = new Date(System.currentTimeMillis() - (2 * 60 * 1000));
			s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
			bsb.setDate5(s);
			d1 = new Date(System.currentTimeMillis() + (17 * 60 * 1000));
			s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
			bsb.setDate4(s);
			d1 = new Date(System.currentTimeMillis() + (38 * 60 * 1000));
			s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
			bsb.setDate3(s);
			d1 = new Date(System.currentTimeMillis() + (49 * 60 * 1000));
			s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
			bsb.setDate2(s);
			d1 = new Date(System.currentTimeMillis() + (63 * 60 * 1000));
			s = d1.getHours() + ":" + d1.getMinutes() + ":" + d1.getSeconds();
			bsb.setDate1(s);

		}
		return bsb;

	}
}
