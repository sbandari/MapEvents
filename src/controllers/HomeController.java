package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import models.Events;
import services.AdminService;

@Controller
public class HomeController {
	AdminService adminService;

	@Autowired
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@RequestMapping("/")
	public String getHome() {

		return "index";
	}

	@RequestMapping("/login")
	public String getlogin() {

		return "login";
	}
	@RequestMapping("/logout")
	public String getlogout() {

		return "logout";
	}
	@RequestMapping("/map")
	public String map(Model model) {
		List<Events> events = adminService.getEvents();
		model.addAttribute("events", events);
		return "map";
	}
}
