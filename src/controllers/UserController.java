package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import models.UserRegisteredEvents;
import models.Users;
import services.UserService;

@Controller
@Scope("session")
@RequestMapping("/user")
public class UserController {
	
	private static String name;
	UserService userservice;
	@Autowired
public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

@RequestMapping("/user")
public String userPage(Model model,HttpSession session){
	Authentication auth=SecurityContextHolder.getContext().getAuthentication();
	String name=auth.getName();
	Users user=userservice.getUserbyEmail(auth.getName());
	List<Object[]> ob=userservice.getEventDetails(user.getUserId());
	session.setAttribute("userid", user.getUserId());
	model.addAttribute("ob", ob);
	model.addAttribute("name", name);
	return "user";
}
@RequestMapping("/deleteRegister/{id}")
public void deleteRegister(@PathVariable("id")int id){
	userservice.deleteRegister(id);
}
@RequestMapping("/register/{eventId}/{userId}")
public void userRegistration(@PathVariable("eventId")int eventId,@PathVariable("userId")int userId){
		userservice.userRegistration(eventId,userId);
	}


}
