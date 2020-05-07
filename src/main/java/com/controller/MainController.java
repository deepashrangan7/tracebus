package com.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.logic.Notification;
import com.logic.SmsService;
import com.logic.UserAuthentication;
import com.model.LoginBean;
import com.model.SignBean;
import com.service.MailFunction;

@Controller
public class MainController {
	@Autowired
	private UserAuthentication userAuthentication;
	@Autowired
	private MailFunction mailFunction;

	@Autowired
	private Notification notification;

	@Autowired
	private SmsService sms;

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("user", null);
		session.setAttribute("vale", null);
		session.setAttribute("pimg", null);

		return "mainpage";
	}

	@GetMapping("/")
	public String mainPage(HttpSession session) {

		session.setAttribute("user", null);
		session.setAttribute("vale", null);
		session.setAttribute("pimg", null);
		session.setAttribute("name", null);

		return "mainpage";
	}

	@RequestMapping("/login")
	public String loginPage(@Valid @ModelAttribute("lBean") LoginBean lBean, BindingResult br, HttpSession session,
			Model m) {

		if (br.hasErrors()) {
			return "loginpage";
		}
		if (lBean.getEmail() != null && lBean.getPassword() == null) {

			if (userAuthentication.isEmailThere(lBean.getEmail().trim())) {
				String pimg = userAuthentication.findImg(lBean.getEmail().trim());
				session.setAttribute("vale", 1);
				session.setAttribute("pimg", pimg);

			} else {

				if (lBean.getEmail().equals(""))
					br.addError(new FieldError("noString", "email", "Please enter a value"));
				else
					br.addError(new FieldError("noAccount", "email", "Sorry No Account Found"));
			} // else
		} // if email !null

		if (lBean.getEmail() != null && lBean.getPassword() != null) {
			if (lBean.getPassword().equals("")) {
				m.addAttribute("err", "Please Enter Pssword");
			} else {
				if (userAuthentication.isPasswordMatch(lBean)) {
					// matched
					m.addAttribute("err", "");
					session.setAttribute("user", lBean.getEmail().trim());// saving the state

					session.setAttribute("name", userAuthentication.findName(lBean.getEmail().trim()));
					m.addAttribute("notic", notification.getNotification(lBean.getEmail().trim()));
					return "userhome";

				} else {
					// no match
					m.addAttribute("err", "Email and Passsword doesn't Match");
				}
			} // else not " "
		} // pas not null mail not null
		return "loginpage";
	}// login page

	@RequestMapping("/signup")
	public String sign(@ModelAttribute("sBean") SignBean sb) {

		return "signpage";
	}

	@RequestMapping("/sign")
	public String signupPage(@Valid @ModelAttribute("sBean") SignBean sb, BindingResult br, HttpSession session,
			Model m) {
		if (br.hasErrors()) {
			return "signpage";
		}
		if (userAuthentication.isEmailThere(sb.getEmail().trim())) {
			m.addAttribute("uerr", "Email already exist .please login or signUp with differnt mail...");
			return "signpage";
		}
		if (sb.getPassword1().equals(sb.getPassword2())) {
			session.setAttribute("user", sb.getEmail().trim());
			session.setAttribute("name", sb.getName().trim());
			userAuthentication.createAccount(sb);
			try {
				mailFunction.sendEmail(sb.getEmail().trim(), sb.getName().trim());
				sms.createdAccount(sb.getEmail().trim(), sb.getName().trim(), "+91" + sb.getPhone());
			} catch (Exception e) {
			}
			return "imageupload";

		} else {
			m.addAttribute("err", "password doesn't match!!");
			sb.setPassword2("");
		}

		return "signpage";
	}

}// class
