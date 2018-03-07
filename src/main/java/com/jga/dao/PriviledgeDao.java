package com.jga.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

public class PriviledgeDao extends BaseDao {
	final String INSERT_WEB_PRI = "INSERT INTO Priviledge (developerId, websiteId, priviledgeId) VALUES (?,?,?)";
	final String INSERT_PAGE_PRI = "INSERT INTO Priviledge (developerId, pageId, priviledgeId) VALUES (?,?,?)";
	final String DELETE_WEB_PRI = "DELETE FROM Priviledge WHERE developerId=?, websiteId=?, priviledgeId=?";
	final String DELETE_PAGE_PRI = "DELETE FROM Priviledge WHERE developerId=?, pageId=?, priviledgeId=?";
	
	public void assignWebsitePriviledge(int developerId, int websiteId, int priviledgeId) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(INSERT_WEB_PRI);

			pstmt.setInt(1, developerId);
			pstmt.setInt(2, websiteId);
			pstmt.setInt(3, priviledgeId);

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

	public void assignPagePriviledge(int developerId, int pageId, int priviledgeId) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(INSERT_WEB_PRI);

			pstmt.setInt(1, developerId);
			pstmt.setInt(2, pageId);
			pstmt.setInt(3, priviledgeId);

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

	public void deleteWebsitePriviledge(int developerId, int websiteId, int priviledgeId) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(DELETE_WEB_PRI);

			pstmt.setInt(1, developerId);
			pstmt.setInt(2, websiteId);
			pstmt.setInt(3, priviledgeId);

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

	public void deletePagePriviledge(int developerId, int pageId, int priviledgeId) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(DELETE_PAGE_PRI);

			pstmt.setInt(1, developerId);
			pstmt.setInt(2, pageId);
			pstmt.setInt(3, priviledgeId);

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
