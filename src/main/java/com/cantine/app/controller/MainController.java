package com.cantine.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cantine.app.entity.User;
import com.cantine.app.repository.IUserDAO;


@Controller
@RequestMapping(value="/")
public class MainController {

	@Autowired
	private IUserDAO userDao;
	
	@RequestMapping(value="",method = RequestMethod.GET)
	public String home(ModelMap mm){
		
//		mm.addAttribute("username",this.getLoggedUser(principal).getUserId());
		return "index";
	}
	@RequestMapping(value={"login"},method = RequestMethod.GET)
	public String login(){
		System.out.println("login");
		return "login";
		
	}
	
	@RequestMapping(value={"getuser"},method = RequestMethod.GET)
	public String getUserLogin(Authentication auth){
		User user = (User) auth.getPrincipal();
		System.out.println(user.getUserId());
		return "index";
		
	}
	
	//share user all pages
	@ModelAttribute
	public void getUserLoggedIn(Model model){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication!=null){
			User user = (User) authentication.getPrincipal();
			model.addAttribute("loggedUser",user);
		}else{
			model.addAttribute("loggedUser","");
		}
		
	}
	
	@RequestMapping(value={"403"},method = RequestMethod.GET)
	public String accessDenied(){
		System.out.println("403");
		return "accessDenied";
	}
}
