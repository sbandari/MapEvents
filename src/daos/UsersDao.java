package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.GeneratorStrategy;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import models.Events;
import models.Users;

@Component
public class UsersDao {
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
	public List<Users> getUsers() {
		/*
		 * return jdbc.query("select * from users", new RowMapper<Users>() {
		 * 
		 * @Override public Users mapRow(ResultSet rs, int rowNum) throws
		 * SQLException { Users users = new Users();
		 * users.setUserId(rs.getInt("userId"));
		 * users.setEmail(rs.getString("email"));
		 * users.setPassword(rs.getString("password")); return users; } });
		 */
		Session session = sessionFactory.openSession();
		String hql = "from users";
		Query query = session.createQuery(hql);
		List<Users> users = query.list();
		
		return users;
	}

	@Transactional
	// create
	public void addUser(Users user) {
		/*
		 * String email = user.getEmail(); String password = user.getPassword();
		 * MapSqlParameterSource params = new MapSqlParameterSource("email",
		 * email); params.addValue("password", password); int i = jdbc.update(
		 * "INSERT INTO users (`email`,`password`) VALUES (:email, :password)",
		 * params); System.out.println("number of rows effected" + i);
		 */
		Session session = sessionFactory.openSession();
		session.save(user);
	}

	@Transactional
	// delete
	public void deleteUser(int userId) {
		/*
		 * MapSqlParameterSource params = new MapSqlParameterSource("userId",
		 * userId); int i = jdbc.update("delete from users where userId=:userId"
		 * , params); System.out.println("rows deleted" + i);
		 */
		Session session = sessionFactory.openSession();
		String hql = "DELETE FROM users " + "WHERE userId = :userId";
		Query query = session.createQuery(hql);
		query.setParameter("userId", userId);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
	}

	@Transactional
	public void updateUser(Users user) {
		/*
		 * int userId = user.getUserId(); String email = user.getEmail(); String
		 * password = user.getPassword(); MapSqlParameterSource params = new
		 * MapSqlParameterSource("email", email); params.addValue("password",
		 * password); params.addValue("userId", userId); int i = jdbc.update(
		 * "UPDATE users SET `userId`=:userId, `email`=:email, `password`=:password WHERE `userId`=:userId;"
		 * , params); System.out.println("number of rows effected" + i);
		 */
		Session session = sessionFactory.openSession();
		String hql = "UPDATE users set email=:email,password=:password " + "WHERE userId = :userId";
		Query query = session.createQuery(hql);
		query.setParameter("userId", user.getUserId());
		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
	}

	public List<Users> getuserById(int userId) {
		Session session = sessionFactory.openSession();
		String hql = "from users " + "WHERE userId = :userId";
		Query query = session.createQuery(hql);
		query.setParameter("userId", userId);
		List<Users> users = query.list();
		return users;
	}

	public Users getUserByEmail(String email) {
		Session session = sessionFactory.openSession();
		String hql = "from users " + "WHERE email = :email";
		Query query = session.createQuery(hql);
		query.setParameter("email", email);
		//List<Users> users = query.list();
		Users user=(Users)query.uniqueResult();
		return user;
	}

}
