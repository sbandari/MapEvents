package models;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "users")
public class Users {
	@Id
	@GeneratedValue
	@Column(name = "userId")
	private int userId;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	
	@OneToMany(mappedBy = "users")
	private Set<UserRegisteredEvents> urEvents;

	public Set<UserRegisteredEvents> getUrEvents() {
		return urEvents;
	}

	public void setUrEvents(Set<UserRegisteredEvents> urEvents) {
		this.urEvents = urEvents;
	}

	public Users(int userId, String email, String password) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
	}

	public Users() {

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", email=" + email + ", password=" + password + "]";
	}

	/*public Set<Events> getEvents() {
		Set<Events> _e = new HashSet<Events>();
		if (null != urEvents && urEvents.size() > 0) {
			for (Iterator<UserRegisteredEvents> iterator = urEvents.iterator(); iterator.hasNext();) {
				UserRegisteredEvents urevents = (UserRegisteredEvents) iterator.next();
				_e.add(urevents.getEvents());

			}
		}

		return _e;
	}*/

}
