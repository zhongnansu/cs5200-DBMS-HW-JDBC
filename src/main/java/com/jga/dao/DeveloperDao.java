package com.jga.dao;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.jga.model.Developer;

public class DeveloperDao extends BaseDao {
	PreparedStatement pstmt1 = null;
	
	final String INSERT_PERSON = "INSERT INTO Person (firstName, lastName, username, password, email,id) VALUES (?,?,?,?,?,?)";
	final String INSERT_DEVELOPER =  "INSERT INTO Developer (developerKey, id) VALUES (?,?)";
	final String SELECT_ALL_DEVELOPERS = "SELECT * FROM Developer d, Person p WHERE d.id = p.id";
	final String SELECT_DEVELOPER_BY_ID = "SELECT * FROM Developer d, Person p WHERE d.id = ? AND d.id = p.id";
	final String SELECT_DEVELOPER_BY_USERNAME = "SELECT * FROM Developer d, Person p WHERE d.username = ? AND p.id = d.id";
	final String SELECT_DEVELOPER_BY_CREDENTIALS = "SELECT * FROM Developer d, Person p WHERE d.username = ? AND d.password = ? AND p.id = d.id";
	final String UPDATE_DEVELOPER_BY_ID = "UPDATE Developer SET id = ?, developerKey = ?, WHERE id = ?;"
			+ "UPDATE Person SET id = ?, firstName = ?, lastName=?, username=?, password=?, email=?, dob=? WHERE id=?";
	final String DELETE_BY_ID = "DELETE FROM Developer WHERE id=?;" + "DELETE FROM Person WHERE id=?";

	private static DeveloperDao instance;

	private DeveloperDao() { }

	public static DeveloperDao getInstance() {
		if (instance == null) {
			instance = new DeveloperDao();
		}
		return instance;
	}

	public int createDeveloper(Developer developer) {

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(INSERT_PERSON);

	
			pstmt.setString(1, developer.getFirstName());
			pstmt.setString(2, developer.getLastName());
			pstmt.setString(3, developer.getUsername());
			pstmt.setString(4, developer.getPassword());
			pstmt.setString(5, developer.getEmail());
			pstmt.setInt(6, developer.getId());
			

			pstmt1 = conn.prepareStatement(INSERT_DEVELOPER);
			pstmt1.setString(1, developer.getDeveloperKey());
			pstmt1.setInt(2, developer.getId());
			pstmt.executeUpdate();
			int res = pstmt1.executeUpdate();
			return res;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				pstmt1.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return -1;
	}

	public Collection<Developer> findAllDevelopers() {
		Collection<Developer> developers = new ArrayList<>();
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(SELECT_ALL_DEVELOPERS);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				String developerKey = res.getString("developerKey");
				String firstName = res.getString("firstName");
				String lastName = res.getString("lastName");
				String username = res.getString("username");
				String password = res.getString("password");
				String email = res.getString("email");
				int id = res.getInt("id");

				Developer d = new Developer(firstName, lastName, username, password, email, id, developerKey);
				developers.add(d);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return developers;
	}

	public Developer findDeveloperById(int developerId) {
		Developer d = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(SELECT_DEVELOPER_BY_ID);
			pstmt.setInt(1, developerId);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				String developerKey = res.getString("developerKey");
				String firstName = res.getString("firstName");
				String lastName = res.getString("lastName");
				String username = res.getString("username");
				String password = res.getString("password");
				String email = res.getString("email");
				Date dob = res.getDate("dob");
				int id = res.getInt("id");

				d = new Developer(firstName, lastName, username, password, email, id, developerKey);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return d;
	}

	public Developer findDeveloperByUsername(String username) {
		Developer d = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(SELECT_DEVELOPER_BY_USERNAME);
			pstmt.setString(1, username);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				String developerKey = res.getString("developerKey");
				String firstName = res.getString("firstName");
				String lastName = res.getString("lastName");
				// String username = res.getString("username");
				String password = res.getString("password");
				String email = res.getString("email");
				Date dob = res.getDate("dob");
				int id = res.getInt("id");

				d = new Developer(firstName, lastName, username, password, email, id, developerKey);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return d;
	}

	public Developer findDeveloperByCredentials(String username, String password) {
		Developer d = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(SELECT_DEVELOPER_BY_CREDENTIALS);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				String developerKey = res.getString("developerKey");
				String firstName = res.getString("firstName");
				String lastName = res.getString("lastName");
				// String username = res.getString("username");
				// String password = res.getString("password");
				String email = res.getString("email");
				Date dob = res.getDate("dob");
				int id = res.getInt("id");

				d = new Developer(firstName, lastName, username, password, email, id, developerKey);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return d;
	}

	public int updateDeveloper(int developerId, Developer developer) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(UPDATE_DEVELOPER_BY_ID);

			pstmt.setInt(1, developer.getId());
			pstmt.setString(2, developer.getDeveloperKey());
			pstmt.setInt(3, developerId);
			pstmt.setInt(4, developer.getId());
			pstmt.setString(5, developer.getFirstName());
			pstmt.setString(6, developer.getLastName());
			pstmt.setString(7, developer.getUsername());
			pstmt.setString(8, developer.getPassword());
			pstmt.setString(9, developer.getEmail());
			pstmt.setDate(10, developer.getDob());
			pstmt.setInt(11, developerId);
			int res = pstmt.executeUpdate();
			return res;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return -1;
	}

	public int deleteDeveloper(int developerId) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(DELETE_BY_ID);

			pstmt.setInt(1, developerId);
			pstmt.setInt(2, developerId);

			int res = pstmt.executeUpdate();
			return res;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return -1;
	}

}
