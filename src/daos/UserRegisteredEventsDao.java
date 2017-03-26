package daos;

import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import models.Events;
import models.UserRegisteredEvents;
import models.Users;

@Component
public class UserRegisteredEventsDao {
	/*
	 * NamedParameterJdbcTemplate jdbc;
	 * 
	 * @Autowired public void setDataSource(DataSource jdbc) { this.jdbc = new
	 * NamedParameterJdbcTemplate(jdbc); }
	 */

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// read
	public List<UserRegisteredEvents> getUrEvents() {
		/*
		 * return jdbc.query("select * from events", new RowMapper<Events>() {
		 * 
		 * @Override public Events mapRow(ResultSet rs, int rowNum) throws
		 * SQLException { Events events = new Events();
		 * events.setUserId(rs.getInt("userId"));
		 * events.setEmail(rs.getString("email"));
		 * events.setPassword(rs.getString("password")); return events; } });
		 */
		Session session = sessionFactory.openSession();
		String hql = "from userregisteredevents";
		Query query = session.createQuery(hql);
		List<UserRegisteredEvents> urevents = query.list();
		// System.out.println(urevents);
		return urevents;

	}

	// create
	//@Transactional
	public void addEvent(UserRegisteredEvents urevent) {
				Session session = sessionFactory.openSession();
				Events events=(Events) session.load(Events.class, urevent.getEventId());
				Users users=(Users) session.load(Users.class, urevent.getUserId());
				UserRegisteredEvents ur=new UserRegisteredEvents(events,users);
		session.save(ur);
	}

	// delete
	public void deleteEvent(int registrationId) {
		/*
		 * MapSqlParameterSource params = new
		 * MapSqlParameterSource("registrationId", registrationId); int i =
		 * jdbc.update(
		 * "delete from userregisteredevents where registrationId=:registrationId"
		 * , params); System.out.println("rows deleted" + i);
		 */
		Session session = sessionFactory.openSession();
		String hql = "DELETE FROM userregisteredevents " + "WHERE registrationId = :registrationId";
		Query query = session.createQuery(hql);
		query.setParameter("registrationId", registrationId);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
	}

	@Transactional
	public void updateEvent(UserRegisteredEvents urevent) {
		Session session = sessionFactory.openSession();
		String hql = "UPDATE userregisteredevents set eventId=:eventID,userId=:userId "
				+ "WHERE registrationId = :registrationId";
		Query query = session.createQuery(hql);
		query.setParameter("userId", urevent.getUserId());
		query.setParameter("registrationId", urevent.getRegistrationId());
		query.setParameter("eventID", urevent.getEventId());
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
	}

	public List<Object[]> getEventDetails(int id) {
		Session session = sessionFactory.openSession();
		String hql = "select e.name,e.description,e.contact,e.city,e.address from events e join e.urEvents u where u.userId=:id and e.eventId=u.eventId";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<Object[]> groupList = (List<Object[]>) query.list();
		return groupList;
	}
}
