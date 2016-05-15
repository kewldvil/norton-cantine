package com.cantine.app.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cantine.app.repository.IUserDAO;





@Controller
@RequestMapping(value="/")
public class MainController {

	@Autowired
	private IUserDAO userDao;
	
	@RequestMapping(value="",method = RequestMethod.GET)
	public String home(ModelMap mm){
		
		mm.addAttribute("username",this.getLoggedUser());
		return "index";
	}
	@RequestMapping(value={"login"},method = RequestMethod.GET)
	public String login(){
		System.out.println("login");
		return "login";
		
	}
	
	private com.cantine.app.entity.User getLoggedUser(Principal principle){
		return userDao.findByUserame(principle.getName());
	}
	
	@RequestMapping(value={"403"},method = RequestMethod.GET)
	public String accessDenied(){
		System.out.println("403");
		return "accessDenied";
	}
}
