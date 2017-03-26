package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity(name = "userregisteredevents")
public class UserRegisteredEvents {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "registrationId")
	private int registrationId;
	@Column(name = "eventId", insertable = false, updatable = false)
	private int eventId;
	@Column(name = "userId", insertable = false, updatable = false)
	private int userId;
	@ManyToOne
	@JoinColumn(name = "eventId")
	private Events events;
	@ManyToOne
	@JoinColumn(name = "userId")
	private Users users;

	public Users getUser() {
		return users;
	}

	public void setUser(Users user) {
		this.users = user;
	}

	public Events getEvents() {
		return events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}

	public UserRegisteredEvents(int registrationId, int eventId, int userId) {
		
		this.registrationId = registrationId;
		this.eventId = eventId;
		this.userId = userId;
	}

	public UserRegisteredEvents(int eventId, int userId) {
		this.eventId = eventId;
		this.userId = userId;
	}

	public UserRegisteredEvents(Events events, Users users) {
		
		this.events = events;
		this.users = users;
	}

	public UserRegisteredEvents() {

	}

	public int getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserRegisteredEvents [registrationId=" + registrationId + ", eventId=" + eventId + ", userId=" + userId
				+ "]";
	}

}
