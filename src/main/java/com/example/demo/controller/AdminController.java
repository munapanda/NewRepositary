package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.AdminEntity;
import com.example.demo.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	AdminService service;
	@GetMapping("/home")
	public String save(Model model)
	{
		AdminEntity entity=new AdminEntity();
		model.addAttribute("entit", entity);
		return "home";
		
}
	@PostMapping(value="/save")
	public String save(@ModelAttribute("entit") AdminEntity entity,Model model)
	{
		String uniqvalue=service.getUniqtValue();
		entity.setVoucher(uniqvalue);
		AdminEntity saved=service.save(entity);
		if(saved.getId()==1) {
			model.addAttribute("UserDetails Saved", "saved");
			service.sendSimpleEmail(entity.getEmail(), "One UniqNumber sent to you"+uniqvalue, "Notification");
		}
		else {
			model.addAttribute("UserDetails not Saved", "notsaved");
		}
		
		return "home";
		
}
}
