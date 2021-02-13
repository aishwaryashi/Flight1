package com.demo.flight_reservation_app_10_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.flight_reservation_app_10_1.entity.User;
import com.demo.flight_reservation_app_10_1.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	
	@RequestMapping("/showLoginPage") 
	public String showLoginpage() {
		return "login/login";
		
	}
	
	@RequestMapping("/showReg") 
	public String showreg() {
		return "login/showReg";
	}
	
	@RequestMapping("/saveReg")
	public String saveReg(@ModelAttribute("user") User user) {
		userRepo.save(user);
		return "login/login";
	}
	
	@RequestMapping("/verifyLogin")
	public String verifyLogin(@RequestParam("emailId") String emailId, @RequestParam("password") String password ,ModelMap modelmap) {

		User user = userRepo.findByEmail(emailId);
		
		if(user!=null) {
		     if(user.getEmail().equals(emailId) && user.getPassword().equals(password)) {
	          return"findFlight";
		      }else {
		       modelmap.addAttribute("error","invalid username/password");
		       return"login/login";
		            }
		}else {
		       modelmap.addAttribute("error","invalid username/password");
		       return "login/login";
		}
		
		
	}

}

