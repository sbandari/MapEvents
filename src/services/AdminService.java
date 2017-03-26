package services;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import daos.EventsDao;
import daos.UserRegisteredEventsDao;
import daos.UsersDao;
import models.Events;
import models.UserRegisteredEvents;
import models.Users;

@Component
public class AdminService {
	UsersDao userDao;
	EventsDao eventDao;
	UserRegisteredEventsDao urDao;

	@Autowired
	public void setUserDao(UsersDao userDao) {
		this.userDao = userDao;
	}

	@Autowired
	public void setUrDao(UserRegisteredEventsDao urDao) {
		this.urDao = urDao;
	}

	@Autowired
	public void setEventDao(EventsDao eventDao) {
		this.eventDao = eventDao;
	}

	public List<Users> getUsers() {
		return userDao.getUsers();
	}

	public void addUsers(Users users) {
		userDao.addUser(users);

	}

	public void deleteUser(int userId) {
		userDao.deleteUser(userId);

	}

	public void updateUser(Users user) {
		userDao.updateUser(user);

	}

	public List<Events> getEvents() {
		return eventDao.getEvents();
	}

	public void addEvent(Events event) {
		eventDao.addEvent(event);

	}

	public void deleteEvent(int eventId) {
		eventDao.deleteEvent(eventId);

	}

	public void updateEvent(Events event) {
		eventDao.updateEvent(event);

	}
	public void addUrevents(UserRegisteredEvents urevents) {
		urDao.addEvent(urevents);

	}
	public List<UserRegisteredEvents> getUrevents() {
		return urDao.getUrEvents();
	}

	public void deleteUrevents(int registrationId) {
		urDao.deleteEvent(registrationId);
	}

	public void updateUrevents(UserRegisteredEvents urevents) {
		urDao.updateEvent(urevents);
	}

	public List<Users> getuserByid(int userid) {
		 return userDao.getuserById(userid);
		
	}
	public List<Events> geteventByid(int eventid) {
		 return eventDao.geteventById(eventid);
		
	}
}
