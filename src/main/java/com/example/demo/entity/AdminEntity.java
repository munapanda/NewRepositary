package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AdminEntity {
	@Id
	@GeneratedValue
	private Integer id;
	private String username;
	private String email;
	private String voucher;
	private String telicomeservices;
	public AdminEntity() {
		super();
	}
	public AdminEntity(Integer id, String username, String email, String voucher, String telicomeservices) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.voucher = voucher;
		this.telicomeservices = telicomeservices;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVoucher() {
		return voucher;
	}
	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}
	public String getTelicomeservices() {
		return telicomeservices;
	}
	public void setTelicomeservices(String telicomeservices) {
		this.telicomeservices = telicomeservices;
	}
	
	
	
}
