package com.cantine.app.controller;

import java.security.Principal;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/")
public class MainController {
	@RequestMapping(value={"login"},method = RequestMethod.GET)
	public String login(){
		System.out.println("login");
		return "login";
		
	}
	
	
	@RequestMapping(value={"403"},method = RequestMethod.GET)
	public String accessDenied(){
		System.out.println("403");
		return "accessDenied";
	}
}
