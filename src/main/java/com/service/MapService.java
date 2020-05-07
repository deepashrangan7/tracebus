package com.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Map;

@Service
public class MapService {

	@Autowired
	private MapDao map;
	@Autowired
	private BusDao busDao;

	@Transactional
	public void addCor() {

		Map m = new Map("gandhipuram", 11.016436, 76.968462);
		map.save(m);
		m = new Map("ganapathy", 11.036009, 76.978195);
		map.save(m);
		m = new Map("sivanandhapuram", 11.051707, 76.992752);
		map.save(m);
		m = new Map("saravanampatty", 11.078159, 77.003370);
		map.save(m);
		m = new Map("kct tech park", 11.081284, 76.990463);
		map.save(m);
		m = new Map("racecourse", 11.003787, 76.981462);
		map.save(m);

		m = new Map("lakshmimills", 11.013540, 76.986694);
		map.save(m);

		m = new Map("puliyakulam", 11.003842, 76.993521);
		map.save(m);

		m = new Map("ramanathapuram", 10.997133, 76.999255);
		map.save(m);

		m = new Map("singanallur", 11.002183, 77.028628);
		map.save(m);

		m = new Map("peelamedu", 11.022968, 77.001046);
		map.save(m);

		m = new Map("thudiyalur", 11.080261, 76.941768);
		map.save(m);

		m = new Map("vadamadurai", 11.074630, 76.941994);
		map.save(m);

		m = new Map("nggocolony", 11.089946, 76.938638);
		map.save(m);

		m = new Map("kavundampalayam", 11.045095, 76.947358);
		map.save(m);

		m = new Map("newbusstop", 11.030011, 76.951157);
		map.save(m);
		m = new Map("ramakrishna", 11.102354, 76.964518);
		map.save(m);

	}

	
}
