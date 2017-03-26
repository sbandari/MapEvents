package models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "events")
public class Events {
	@Column(name = "name")
	private String name;
	@Column(name = "longitude")
	private double longitude;
	@Column(name = "latitude")
	private double latitude;
	@Column(name = "eventId")
	@GeneratedValue
	@Id
	private int eventId;
	@Column(name = "description")
	private String description;
	@Column(name = "contact")
	private String contact;
	@Column(name = "city")
	String city;
	@Column(name = "address")
	private String address;
	@OneToMany(mappedBy = "events")
	private Set<UserRegisteredEvents> urEvents;

	public Set<UserRegisteredEvents> getUrEvents() {
		return urEvents;
	}

	public Events(String name, double longitude, double latitude, int eventId, String description, String contact,
			String city, String address, Set<UserRegisteredEvents> urEvents) {
		super();
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.eventId = eventId;
		this.description = description;
		this.contact = contact;
		this.city = city;
		this.address = address;
		this.urEvents = urEvents;
	}

	public void setUrEvents(Set<UserRegisteredEvents> urEvents) {
		this.urEvents = urEvents;
	}

	public Events(String name, double longitude, double latitude, int eventId, String description, String contact,
			String city, String address) {
		super();
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.eventId = eventId;
		this.description = description;
		this.contact = contact;
		this.city = city;
		this.address = address;
	}

	public Events() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Events [name=" + name + ", longitude=" + longitude + ", latitude=" + latitude + ", eventId=" + eventId
				+ ", description=" + description + ", contact=" + contact + ", city=" + city + ", address=" + address
				+ "]";
	}

}
