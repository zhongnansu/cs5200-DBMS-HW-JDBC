package com.jga.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.jga.model.Role;

public class RoleDao extends BaseDao {
	final String INSERT_WEBROLE = "INSERT INTO WebsiteRole (roleType, developerId, websiteId) VALUES (?,?,?)";
	final String INSERT_PAGEROLE = "INSERT INTO PageRole (roleType, developerId, pageId) VALUES (?,?,?)";
	final String DELETE_WEBROLE = "DELETE FROM WebsiteRole WHERE roleType=?, developerId=?, websiteId=? ";
	final String DELETE_PAGEROLE = "DELETE FROM PageRole WHERE roleType=?, developerId=?, pageId=? ";
	
	private static RoleDao instance;
	private RoleDao() {};
	public static RoleDao getInstance() {
		if (instance == null) {
			instance = new RoleDao();
		}
		return instance;
	}
	
	
	public void assignWebsiteRole(int developerId, int websiteId, String roleType) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(INSERT_WEBROLE);
			
			pstmt.setString(1, roleType);
			pstmt.setInt(2, developerId);
			pstmt.setInt(3, websiteId);
			 
			pstmt.executeUpdate();
	

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
	}
	
	public void assignPageRole(int developerId, int pageId, String roleType) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(INSERT_PAGEROLE);
		
			pstmt.setString(1, roleType);
			pstmt.setInt(2, developerId);
			pstmt.setInt(3, pageId);
			 
			pstmt.executeUpdate();
	

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
	}
	
	
	public void deleteWebsiteRole(int developerId, int websiteId, String roleType) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(INSERT_WEBROLE);
		
			pstmt.setString(1, roleType);
			pstmt.setInt(2, developerId);
			pstmt.setInt(3, websiteId);
			 
			pstmt.executeUpdate();
	

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
	}
	
	public void deletePageRole(int developerId, int pageId, String roleType) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(DELETE_PAGEROLE);
		
			pstmt.setString(1, roleType);
			pstmt.setInt(2, developerId);
			pstmt.setInt(3, pageId);
			 
			pstmt.executeUpdate();
	

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
	}
}

	