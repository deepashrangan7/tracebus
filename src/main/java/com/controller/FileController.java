package com.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.logic.Notification;
import com.logic.UserAuthentication;
import com.model.ProfileImage;
import com.service.ImageService;
import com.service.ProfileDao;

@Controller
public class FileController {

	@Autowired
	private ImageService imgServ;
	@Autowired
	private ProfileDao pd;
	@Autowired
	private UserAuthentication UserAuthentication;

	@Autowired
	private Notification notification;

	@RequestMapping("/up")
	public String uploadPage() {

		return "photoupload";
	}

	@PostMapping("/upload")
	public String fileUpload(@RequestParam("file") MultipartFile file, HttpSession session, Model m) {
		try {

			byte[] image = file.getBytes();
			String id = (String) session.getAttribute("user");
			ProfileImage model = new ProfileImage(id, image);

//			System.out.println(id+" "+file);
			int saveImage = imgServ.saveImage(model);
			if (saveImage == 1) {
				String pimg = UserAuthentication.findImg(id.trim());
				session.setAttribute("pimg", pimg);
				m.addAttribute("notic", notification.getNotification(id.trim()));

				return "userhome";
			} else {
				return "error";
			}
		} catch (Exception e) {
//			System.out.println("ERROR " + e);
			return "error";
		}
	}

	@RequestMapping("/gee")
	public void gee() throws IOException {
		imgServ.printImg("deepashdeepika77@gmail.com");
	}

	@RequestMapping("/geev")
	public String geev(Model m) {
		StringBuilder sb = new StringBuilder();

		m.addAttribute("image", "deepash.jpg");
		return "imagedetails";

	}

	@GetMapping("/noupload")
	public String noUpload(HttpSession s,Model m) {
		s.setAttribute("pimg", null);
		pd.save(new ProfileImage((String) s.getAttribute("user"), null));
		m.addAttribute("notic", notification.getNotification((String) s.getAttribute("user")));
		
		return "userhome";
	}

}
