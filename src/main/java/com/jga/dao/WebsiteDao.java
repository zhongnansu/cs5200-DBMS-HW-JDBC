package com.jga.dao;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.jga.model.Website;

public class WebsiteDao extends BaseDao {
	final String INSERT_WEBSITE = "INSERT INTO Website (developerId, name, description, created, updated, visits, id) VALUES (?,?,?,?,?,?,?)";
	final String SELECT_ALL_WEBSITES = "SELECT * FROM Website";
	final String SELECT_WEBSITE_BY_ID = "SELECT * FROM Website WHERE developerId = ?";
	final String SELECT_BY_WEB_ID = "SELECT * FROM Website WHERE id=?";
	final String UPDATE_BY_ID = "UPDATE Website SET name=?, description=?, created=?, updated=?, visits=?, id=? WHERE id=?";	
	final String DELETE_BY_WEB_ID = "DELETE FEOM Website WHERE id=?";
	
	private static WebsiteDao instance;
	private WebsiteDao() {};
	public static WebsiteDao getInstance() {
		if (instance == null) {
			instance = new WebsiteDao();
		}
		return instance;
	}
	
 	public int createWebsiteForDeveloper(int developerId, Website website) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(INSERT_WEBSITE);
		
			pstmt.setInt(1, developerId);
			pstmt.setString(2, website.getName());
			pstmt.setString(3, website.getDescription());
			pstmt.setDate(4, website.getCreated());
			pstmt.setDate(5, website.getUpdated());
			pstmt.setInt(6, website.getVisits());
			pstmt.setInt(7, website.getId());
			
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
	
	public Collection<Website> findAllWebsites() {
		Collection<Website> websites = new ArrayList<>();
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(SELECT_ALL_WEBSITES);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				String name = res.getString("name");
				String description = res.getString("description");
				Date created = res.getDate("created");
				Date updated = res.getDate("updated");
				Integer visits = res.getInt("visits");
				Integer id = res.getInt("id");
				
				Website w = new Website(name, description, created, updated, visits, id);
				websites.add(w);
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
		return websites;
	}
	
	public Collection<Website> findWebsitesForDeveloper(int developerId) {
		Collection<Website> websites = new ArrayList<>();
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(SELECT_WEBSITE_BY_ID);
			pstmt.setInt(1, developerId);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				String name = res.getString("name");
				String description = res.getString("description");
				Date created = res.getDate("created");
				Date updated = res.getDate("updated");
				Integer visits = res.getInt("visits");
				Integer id = res.getInt("id");
				
				Website w = new Website(name, description, created, updated, visits,id);
				websites.add(w);
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
		return websites;
	}
	
	public Website findWebsiteById(int websiteId) {
		Website w = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(SELECT_WEBSITE_BY_ID);
			pstmt.setInt(1, websiteId);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				String name = res.getString("name");
				String description = res.getString("description");
				Date created = res.getDate("created");
				Date updated = res.getDate("updated");
				Integer visits = res.getInt("visits");
				Integer id = res.getInt("id");
				
				w = new Website(name, description, created, updated, visits,id);
			
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
		return w;
	}
	
	
	public int updateWebsite(int websiteId, Website website) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(UPDATE_BY_ID);
		
			pstmt.setString(1, website.getName());
			pstmt.setString(2, website.getDescription());
	 
			pstmt.setDate(3, website.getCreated());
			pstmt.setDate(4, website.getUpdated());
			pstmt.setInt(5, website.getVisits());
			pstmt.setInt(6, website.getId());
			pstmt.setInt(7, websiteId);
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
	
	public int deleteWebsite(int websiteId) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(DELETE_BY_WEB_ID);
		
			pstmt.setInt(1, websiteId);

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
