package com.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.ProfileImage;

@Service
public class ImageService {

	@Autowired
	private ProfileDao dao;

	public int saveImage(ProfileImage model) {
		try {

			dao.save(model);
			return 1;
		} catch (Exception e) {

			return 0;
		}
	}

	public ProfileImage getImages(String id) {
		Optional<ProfileImage> findById = dao.findById(id);
		if (findById.isPresent()) {
			ProfileImage getImageDetails = findById.get();
			return getImageDetails;
		} else {
			return null;
		}
	}

	public String printImg(String id) {
		try {
			Optional<ProfileImage> o = dao.findById(id);
			ProfileImage pi;
			if (o.isPresent()) {
				pi = o.get();
				String f1[] = pi.getId().split("@");
				String f2="D:\\spfile\\finalyearproject\\src\\main\\webapp\\"+f1[0]+".jpg";
				File f = new File(f2);
				FileOutputStream fos = new FileOutputStream(f);
				fos.write(pi.getImage());
				fos.close();
				return f1[0] + ".jpg";
			} else {
			}
		} catch (Exception e) {

			System.out.println("Cant Download Image "+e.getMessage());
		}
		return null;
	}
}
