package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import models.Events;
import models.Users;

@Component
public class EventsDao {
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
	public List<Events> getEvents() {
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
		String hql = "from events";
		Query query = session.createQuery(hql);
		List<Events> events = query.list();
		// System.out.println(events);
		return events;

	}

	// create
	@Transactional
	public void addEvent(Events event) {
		Session session = sessionFactory.openSession();
		session.save(event);
	}

	@Transactional
	// delete
	public void deleteEvent(int eventId) {
		/*
		 * MapSqlParameterSource params = new MapSqlParameterSource("userId",
		 * eventId); int i = jdbc.update(
		 * "delete from events where eventId=:eventId", params);
		 * System.out.println("rows deleted" + i);
		 */
		Session session = sessionFactory.openSession();
		String hql = "DELETE FROM events " + "WHERE eventId = :eventId";
		Query query = session.createQuery(hql);
		query.setParameter("eventId", eventId);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
	}

	@Transactional
	public void updateEvent(Events event) {
		Session session = sessionFactory.openSession();
		String hql = "UPDATE events set name=:name,longitude=:longitude,latitude=:latitude,description=:description,contact=:contact,city=:city,address=:address"
				+ "WHERE eventId = :eventId";
		Query query = session.createQuery(hql);
		query.setParameter("name", event.getName());
		query.setParameter("eventId", event.getEventId());
		query.setParameter("longitude", event.getLongitude());
		query.setParameter("latitude", event.getLatitude());
		query.setParameter("description", event.getDescription());
		query.setParameter("contact", event.getContact());
		query.setParameter("city", event.getCity());
		query.setParameter("address", event.getAddress());
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
	}

	public List<Events> geteventById(int eventid) {
		Session session = sessionFactory.openSession();
		String hql = "from events " + "WHERE eventId = :eventid";
		Query query = session.createQuery(hql);
		query.setParameter("eventid", eventid);
		List<Events> event = query.list();
		return event;
	}

}
