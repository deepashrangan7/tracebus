package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class ProfileImage {
	@Id
	private String id;
	@Lob
	private byte[] image;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte[] getImage() {
		return image;
	}

	public ProfileImage(String id, byte[] image) {
		super();
		this.id = id;
		this.image = image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public ProfileImage() {
		super();
	}

}
