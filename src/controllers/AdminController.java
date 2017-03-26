package controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import models.Events;
import models.UserRegisteredEvents;
import models.Users;

import services.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	AdminService adminService;

	@Autowired
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@RequestMapping("/admin")
	public String displayusers(Model model) {
		List<Users> usersList = adminService.getUsers();
		// System.out.println(usersList);
		List<Events> EventsList = adminService.getEvents();
		List<UserRegisteredEvents> regisEvents = adminService.getUrevents();
		// System.out.println(EventsList);
		model.addAttribute("usersList", usersList);
		model.addAttribute("EventsList", EventsList);
		model.addAttribute("regisEvents", regisEvents);
		/*
		 * Users user = new Users(); Set<Events> test = user.getEvents();
		 * System.out.println(test);
		 */
		return "admin";
	}

	@RequestMapping("/userAdd")

	public String adduserView(Users users) {
		return "addUser";
	}

	@RequestMapping("/addUser")
	@ResponseBody
	public ModelAndView addUser(Model model, @ModelAttribute("users") Users users) {
		// for testing
		/*
		 * Users user = new Users(); user.setEmail("test@email.com");
		 * user.setPassword("test");
		 */
		adminService.addUsers(users);
		return new ModelAndView("redirect:/admin/admin");
	}

	@RequestMapping("/userDelete/{id}")

	public ModelAndView removePerson(@PathVariable("id") int userId) {
		adminService.deleteUser(userId);
		return new ModelAndView("redirect:/admin/admin");
	}

	@RequestMapping("/userEdit/{userid}")
	public String edituser(Users users, @PathVariable("userid") int userid, Model model) {
		List<Users> user = adminService.getuserByid(userid);
		model.addAttribute("user", user);

		return "editUser";
	}

	@RequestMapping("/userUpdate")
	public ModelAndView updateUser(Model model, @ModelAttribute("users") Users users) {
		// for testing
		/*
		 * Users user = new Users(); user.setUserId(1);
		 * user.setEmail("testupdate@email.com");
		 * user.setPassword("testupdate");
		 */
		// System.out.println(users);
		adminService.updateUser(users);
		return new ModelAndView("redirect:/admin/admin");
	}

	@RequestMapping("/eventAdd")

	public String addeventView(Events events) {
		return "addEvent";
	}

	@RequestMapping("/addEvent")
	public ModelAndView addEvent(Model model, @ModelAttribute("events") Events events) {
		// for testing

		adminService.addEvent(events);
		return new ModelAndView("redirect:/admin/admin");
	}

	@RequestMapping("/eventDelete/{id}")
	public ModelAndView removeEvent(@PathVariable("id") int eventId) {
		adminService.deleteEvent(eventId);
		return new ModelAndView("redirect:/admin/admin");
	}

	@RequestMapping("/eventEdit/{eventid}")
	public String edituser(Events events, @PathVariable("eventid") int eventid, Model model) {
		List<Events> event = adminService.geteventByid(eventid);
		model.addAttribute("event", event);

		return "editEvent";
	}

	@RequestMapping("/eventUpdate")
	public ModelAndView updateEvent(Model model, @ModelAttribute("events") Events events) {
		// for testing
		adminService.updateEvent(events);
		return new ModelAndView("redirect:/admin/admin");
	}

	@RequestMapping("/editUrEvents")
	public ModelAndView updateUrevent(@ModelAttribute("events") UserRegisteredEvents events) {
		adminService.updateUrevents(events);
		return new ModelAndView("redirect:/admin/admin");
	}

	@RequestMapping("/deleteUrEvents/{id}")
	public ModelAndView delteUrevent(@PathVariable("id") int id) {
		adminService.deleteUrevents(id);
		return new ModelAndView("redirect:/admin/admin");
	}
	
	@RequestMapping("/ureventAdd")

	public String addureventAdd(UserRegisteredEvents urevents) {
		return "ureventAdd";
	}

	@RequestMapping("/addurevent")
	public ModelAndView addurevent(Model model, @ModelAttribute("urevents") UserRegisteredEvents urevents) {
		// for testing

		adminService.addUrevents(urevents);
		return new ModelAndView("redirect:/admin/admin");
	}
}
