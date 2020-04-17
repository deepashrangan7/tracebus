package com.logic;

import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.LoginBean;
import com.model.SignBean;
import com.model.UserBean;
import com.service.ImageService;
import com.service.UserDao;

@Service
public class UserAuthentication {

	@Autowired
	private UserDao userDao;
	@Autowired
	private ImageService is;

	public String findImg(String email) {
		String img = is.printImg(userDao.findById(email).get().getEmail());
		System.out.println(img+" in img");
		return img;
	}

	public boolean isEmailThere(String email) {
		boolean flag = false;
		Optional<UserBean> o = userDao.findById(email);
		if (o.isPresent()) {
			flag = true;
		}
		return flag;
	}

	public boolean isPasswordMatch(LoginBean lb) {
		boolean flag = false;
		try {
			if (decode(userDao.findById(lb.getEmail().trim()).get().getPassword().trim()).trim()
					.equals(lb.getPassword()))
				flag = true;
		} catch (Exception e) {

		}
		return flag;
	}

	public void createAccount(SignBean sb) {

		String pass = encode(sb.getPassword1().trim());
		sb.setPassword1(pass.trim());
		UserBean ub = new UserBean(sb.getName().trim(), sb.getPassword1().trim(), sb.getEmail().trim());
		userDao.save(ub);

	}

	public String encode(String s) {
		Base64.Encoder encoder = Base64.getEncoder();
		s = encoder.encodeToString(s.getBytes());
		return s;

	}

	public String decode(String password) {

		Base64.Decoder decoder = Base64.getDecoder();
		password = new String(decoder.decode(password.getBytes()));
		return password;

	}

	public String findName(String trim) {
		return userDao.findById(trim).get().getName();
		
	}

}
