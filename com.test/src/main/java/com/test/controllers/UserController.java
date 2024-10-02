package com.test.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.entities.User;
import com.test.services.UserService;

@Controller
public class UserController {
	@Autowired
	UserService service;
	@PostMapping("/addUser")
	public String addUser(@RequestParam String username,
			@RequestParam String accountType
			,@RequestParam List<String> friends,
			Model model) {
		User user=new User();
		user.setUsername(username);
		user.setAccountType(accountType);
		user.setFriends(friends);
		
		service.addData(user);
		List<User> users=service.getAllUsers();
		model.addAttribute("users",users);
		return "accounttype";
	}
	@PostMapping("/getData")
	public String getUser(@RequestParam Long id,Model model ) {
		String loginuser="siri";
		System.out.print(id);
		User user=service.getSpecificUser(id);
		String actype=user.getAccountType();
		String na=user.getUsername();
		List<String> frlist=user.getFriends();
		System.out.print("friendslist "+frlist);
		for(Object names:frlist) {
			if(names.equals(loginuser)) {
				return "public";
			}
		}
		if(actype.equals("private"))
		{	
			
			User userreq=service.getSpecificUser(id);
			model.addAttribute("user",userreq);				
			return "private";
		}
			return "public";
	}
//notifications
	@PostMapping("/addNotification")
	public String acceptRequest(@RequestParam Long id,Model model)
	{
		String loginuser="sireesha";
		User requestinguser=service.getSpecificUser(id);
		List<String> notify=requestinguser.getNotification();
		if(notify==null) {
			notify = new ArrayList<String>();
		}
		notify.add(loginuser);
		
		requestinguser.setNotification(notify);
		service.addData(requestinguser);
		model.addAttribute("user",requestinguser);
		System.out.println(notify);
		return "confirmform";
	}
//displaying notifications
	@GetMapping("/mynotifications")
	public String mynotifications(Model model) {
		String loginuser="praveena";
		User user=service.getUsername(loginuser);
		List<String> notify=user.getNotification();
		model.addAttribute("notification",notify);
		
		System.out.print(notify);
		return "mynotifications";
	}
	
	@PostMapping("/addmyfriend")
	public String confirmfriend(@RequestParam String username) {
	    String loginuser = "praveena"; // You should dynamically get the logged-in user
	    System.out.println("Requested username: " + username);
	    
	    User user=service.getUsername(loginuser);
	    if (user == null) {
	        System.out.println("User not found: " + loginuser);
	        return "error"; // Handle appropriately
	    }
	    
	    List<String> frds = user.getFriends();
	    if (frds == null) {
	        frds = new ArrayList<>();
	    }
	    
	    if (!frds.contains(username)) { // Avoid adding duplicates
	        frds.add(username);
	    }
	    
	    user.setFriends(frds); // Ensure you have a setter for friends
	    service.addData(user); // Save the user back to the database
	    
	    return "index"; // Redirect or return a view name
	}

	
}
