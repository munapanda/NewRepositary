package com.example.demo.service;

import com.example.demo.entity.AdminEntity;

public interface AdminService {
	public AdminEntity save(AdminEntity entity);
	public String getUniqtValue();
	public void sendSimpleEmail(String toEmail,
            String body,
            String subject);

}
