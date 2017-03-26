package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import daos.UserRegisteredEventsDao;
import daos.UsersDao;
import models.UserRegisteredEvents;
import models.Users;

@Component
public class UserService {
	private UserRegisteredEventsDao urdao;
	private UsersDao userDao;

	@Autowired
	public void setUserDao(UsersDao userDao) {
		this.userDao = userDao;
	}

	@Autowired
	public void setUrdao(UserRegisteredEventsDao urdao) {
		this.urdao = urdao;
	}

	public List<UserRegisteredEvents> getRegirations() {
		return urdao.getUrEvents();
	}

	public void deleteRegister(int ureventId) {
		urdao.deleteEvent(ureventId);

	}

	public List<Object[]> getEventDetails(int userId) {
		return urdao.getEventDetails(userId);
	}

	public Users getUserbyEmail(String email) {

		return userDao.getUserByEmail(email);
	}

	public void userRegistration(int eventId, int userId) {
		UserRegisteredEvents urevents = new UserRegisteredEvents(eventId, userId);
		urdao.addEvent(urevents);
	}

}
