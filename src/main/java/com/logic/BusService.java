package com.logic;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.BusBean;
import com.model.BusSpecificBean;
import com.model.KnowYourBusses;
import com.model.SearchBean;
import com.service.BusDao;

@Service
public class BusService {

	@Autowired
	private BusDao busDao;
	@Autowired
	private BusLogic busLogic;

	public List<KnowYourBusses> knowMyBusses(SearchBean sb) {
		List<KnowYourBusses> listOfBusses = new ArrayList<>();
		List<BusBean> busses = busDao.KnowYourBus(sb.getBoarding(), sb.getDestination());
		for (BusBean b : busses) {
			listOfBusses.add(new KnowYourBusses(b.getBus_no(), b.getLoc()));
			int stops = no_of_gape(b, sb.getBoarding(), sb.getDestination());
			listOfBusses.get(listOfBusses.size() - 1).setStops(stops);
//			System.out.println(listOfBusses.get(listOfBusses.size()-1));
		}
		return listOfBusses;
	}

	public List<Integer> allBus() {
		List<Integer> obj = new ArrayList<>();
		for (BusBean b : busDao.findAll()) {
			if (!(obj.contains(b.getBus_no()))) {
				obj.add(b.getBus_no());
			}
		}
		return obj;
	}

	public List<String> allBusStop() {
		List<BusBean> bb = busDao.findAll();
		List<String> busStop = new ArrayList<>();
		for (BusBean b : bb) {
			if (!(busStop.contains(b.getStop1())))
				busStop.add(b.getStop1());
			if (!(busStop.contains(b.getStop2())))
				busStop.add(b.getStop2());
			if (!(busStop.contains(b.getStop3())))
				busStop.add(b.getStop3());
			if (!(busStop.contains(b.getStop4())))
				busStop.add(b.getStop4());
			if (!(busStop.contains(b.getStop5())))
				busStop.add(b.getStop5());

		}
		return busStop;
	}

	public int no_of_gape(BusBean b, String s1, String s2) {
		int tot = 0;

		if (b.getStop1().equalsIgnoreCase(s1.toLowerCase())) {
			if (b.getStop2().equalsIgnoreCase(s2.toLowerCase()))
				tot = 0;
			else if (b.getStop3().equalsIgnoreCase(s2.toLowerCase()))
				tot = 1;
			else if (b.getStop4().equalsIgnoreCase(s2.toLowerCase()))
				tot = 2;
			else if (b.getStop5().equalsIgnoreCase(s2.toLowerCase()))
				tot = 3;
		} else if (b.getStop2().equalsIgnoreCase(s1.toLowerCase())) {
			if (b.getStop1().equalsIgnoreCase(s2.toLowerCase()))
				tot = 0;
			else if (b.getStop3().equalsIgnoreCase(s2.toLowerCase()))
				tot = 1;
			else if (b.getStop4().equalsIgnoreCase(s2.toLowerCase()))
				tot = 2;
			else if (b.getStop5().equalsIgnoreCase(s2.toLowerCase()))
				tot = 3;
		} else if (b.getStop3().equalsIgnoreCase(s1.toLowerCase())) {
			if (b.getStop2().equalsIgnoreCase(s2.toLowerCase()))
				tot = 0;
			else if (b.getStop1().equalsIgnoreCase(s2.toLowerCase()))
				tot = 1;
			else if (b.getStop4().equalsIgnoreCase(s2.toLowerCase()))
				tot = 2;
			else if (b.getStop5().equalsIgnoreCase(s2.toLowerCase()))
				tot = 3;
		} else if (b.getStop4().equalsIgnoreCase(s1.toLowerCase())) {
			if (b.getStop2().equalsIgnoreCase(s2.toLowerCase()))
				tot = 0;
			else if (b.getStop3().equalsIgnoreCase(s2.toLowerCase()))
				tot = 1;
			else if (b.getStop1().equalsIgnoreCase(s2.toLowerCase()))
				tot = 2;
			else if (b.getStop5().equalsIgnoreCase(s2.toLowerCase()))
				tot = 3;
		} else if (b.getStop5().equalsIgnoreCase(s1.toLowerCase())) {
			if (b.getStop2().equalsIgnoreCase(s2.toLowerCase()))
				tot = 0;
			else if (b.getStop3().equalsIgnoreCase(s2.toLowerCase()))
				tot = 1;
			else if (b.getStop4().equalsIgnoreCase(s2.toLowerCase()))
				tot = 2;
			else if (b.getStop1().equalsIgnoreCase(s2.toLowerCase()))
				tot = 3;
		}
		return tot;
	}

	public BusSpecificBean findSpecific(int bus_no) {
		BusBean b = busDao.findById(bus_no).get();
		BusSpecificBean bsb = new BusSpecificBean();
		bsb.setBus_no(bus_no);
		bsb.setBusStop1(b.getStop1());
		bsb.setBusStop2(b.getStop2());
		bsb.setBusStop3(b.getStop3());
		bsb.setBusStop4(b.getStop4());
		bsb.setBusStop5(b.getStop5());
		bsb.setLoc(b.getLoc());
		bsb = setTime(bsb, b.getDirection());
		bsb = busLogic.setTime(bsb, b.getDirection());

		System.out.println(bsb);
		return bsb;
	}

	public BusSpecificBean setTime(BusSpecificBean b, String direction) {
		if (b.getBusStop1().equals(b.getLoc())) {
			b.setTime1("arrived");
			b.setTime2("next stop");
			b.setTime3("yet to come");
			b.setTime4("yet to come");
			b.setTime5("yet to come");

		} else if (b.getBusStop2().equals(b.getLoc())) {
			if (direction.equals("up")) {
				b.setTime1("crossed");
				b.setTime2("arrived");
				b.setTime3("next stop");
				b.setTime4("yet to come");
				b.setTime5("yet to come");

			} else {
				b.setTime1("next stop");
				b.setTime2("arrived");
				b.setTime3("crossed");
				b.setTime4("crossed");
				b.setTime5("crossed");
			}

		} else if (b.getBusStop3().equals(b.getLoc())) {
			if (direction.equals("up")) {
				b.setTime1("crossed");
				b.setTime2("crossed");
				b.setTime3("arrived");
				b.setTime4("next stop");
				b.setTime5("yet to come");
			} else {
				b.setTime5("crossed");
				b.setTime4("crossed");
				b.setTime3("arrived");
				b.setTime2("next stop");
				b.setTime1("yet to come");

			}
		} else if (b.getBusStop4().equals(b.getLoc())) {
			if (direction.equals("up")) {

				b.setTime1("crossed");
				b.setTime2("crossed");
				b.setTime3("crossed");
				b.setTime4("arrived");
				b.setTime5("next stop");
			} else {
				b.setTime1("yet to come");
				b.setTime2("yet to come");
				b.setTime5("crossed");
				b.setTime4("arrived");
				b.setTime3("next stop");

			}
		} else if (b.getBusStop5().equals(b.getLoc())) {

			b.setTime1("yet to come");
			b.setTime2("yet to come");
			b.setTime3("yet to come");
			b.setTime4("next stop");
			b.setTime5("arrived");

		}
		return b;
	}

	@Transactional
	public void changeLoc(Integer bus_no) {

		BusBean b = busDao.findById(bus_no).get();
		String dir = b.getDirection();
		String loc = b.getLoc();
		if (dir.equals("up")) {
			if (loc.equals(b.getStop1())) {
				b.setLoc(b.getStop2());
			} else if (loc.equals(b.getStop2())) {
				b.setLoc(b.getStop3());
			} else if (loc.equals(b.getStop3())) {
				b.setLoc(b.getStop4());
			} else if (loc.equals(b.getStop4())) {
				b.setLoc(b.getStop5());
				b.setDirection("down");
			}

		} // up
		else {

			if (loc.equals(b.getStop2())) {
				b.setLoc(b.getStop1());
				b.setDirection("up");
			} else if (loc.equals(b.getStop3())) {
				b.setLoc(b.getStop2());
			} else if (loc.equals(b.getStop4())) {
				b.setLoc(b.getStop3());
			} else if (loc.equals(b.getStop5())) {
				b.setLoc(b.getStop4());
			}

		}
		busDao.save(b);
	}

	public String nextLoc(Integer bus_no, BusBean b) {

		String loc = b.getLoc();
		String loc1="";
		if (b.getDirection().equals("up")) {

			if (loc.equals(b.getStop1())) {
				loc1=(b.getStop2());
			} else if (loc.equals(b.getStop2())) {
				loc1=(b.getStop3());
			} else if (loc.equals(b.getStop3())) {
				loc1=(b.getStop4());
			} else if (loc.equals(b.getStop4())) {
				loc1=b.getStop5();
			}

		} else {

			if (loc.equals(b.getStop2())) {
				loc1=(b.getStop1());
//				b.setDirection("up");
			} else if (loc.equals(b.getStop3())) {
				loc1=(b.getStop2());
			} else if (loc.equals(b.getStop4())) {
				loc1=(b.getStop3());
			} else if (loc.equals(b.getStop5())) {
				loc1=(b.getStop4());
			}


		}
		return loc1;
	}
}
