package com.sugmya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sugmya.service.CompanyService;

@Controller
public class CompanyController {
	
	@Autowired
	CompanyService  companyService;
	
	
	public String hello() {
		return ""+companyService.login("kapil", "kapil");
	}
	
}
