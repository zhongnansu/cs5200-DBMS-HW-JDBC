package com.jga.dao;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.jga.model.Page;

public class PageDao extends BaseDao {
	final String INSERT_PAGE = "INSERT INTO Page (websiteId, title, description, created, updated, views, id) VALUES (?,?,?,?,?,?,?)";
	final String SELECT_ALL_PAGES = "SELECT * FROM Page";
	final String SELECT_PAGE_BY_ID = "SELECT * FROM Page WHERE id = ?";
	final String SELECT_BY_WEB_ID = "SELECT * FROM Page WHERE websiteId=?";
	final String UPDATE_BY_ID = "UPDATE Page SET title=?, description=?, created=?, updated=?, views=?, id=? WHERE id=?";	
	final String DELETE_BY_PAGE_ID = "DELETE FEOM Page WHERE id=?";
	
	private static PageDao instance;
	private PageDao() {};
	public static PageDao getInstance() {
		if (instance == null) {
			instance = new PageDao();
		}
		return instance;
	}
	
 	public int createPageForWebsite(int websiteId, Page page) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(INSERT_PAGE);
		
			pstmt.setInt(1, websiteId);
			pstmt.setString(2, page.getTitle());
			pstmt.setString(3, page.getDescription());
			pstmt.setDate(4, page.getCreated());
			pstmt.setDate(5, page.getUpdated());
			pstmt.setInt(6, page.getViews());
			pstmt.setInt(7, page.getId());
			
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
	
	public Collection<Page> findAllPages() {
		Collection<Page> pages = new ArrayList<>();
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(SELECT_ALL_PAGES);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				String title = res.getString("title");
				String description = res.getString("description");
				Date created = res.getDate("created");
				Date updated = res.getDate("updated");
				Integer views = res.getInt("views");
				Integer id = res.getInt("id");
				
				Page p = new Page(title, description, created, updated, views, id);
				pages.add(p);
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
		return pages;
	}
	
	public Page findPageById(int pageId) {
		Page p = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(SELECT_PAGE_BY_ID);
			pstmt.setInt(1, pageId);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				String title = res.getString("title");
				String description = res.getString("description");
				Date created = res.getDate("created");
				Date updated = res.getDate("updated");
				Integer views = res.getInt("views");
				Integer id = res.getInt("id");
				p = new Page(title, description, created, updated, views, id);
				
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
		
		return p;
	}
	
	public Collection<Page> findPagesForWebsite(int websiteId) {
		Collection<Page> pages = new ArrayList<>();
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(SELECT_PAGE_BY_ID);
			pstmt.setInt(1, websiteId);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				String title = res.getString("title");
				String description = res.getString("description");
				Date created = res.getDate("created");
				Date updated = res.getDate("updated");
				Integer views = res.getInt("views");
				Integer id = res.getInt("id");
				
				Page p = new Page(title, description, created, updated, views, id);
				pages.add(p);
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
		return pages;
	}
	
	
	public int updatePage(int pageId, Page page) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(UPDATE_BY_ID);
		
			pstmt.setString(1, page.getTitle());
			pstmt.setString(2, page.getDescription());
	 
			pstmt.setDate(3, page.getCreated());
			pstmt.setDate(4, page.getUpdated());
			pstmt.setInt(5, page.getViews());
			pstmt.setInt(6, page.getId());
			pstmt.setInt(7, pageId);
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
	
	public int deletePage(int pageId) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(DELETE_BY_PAGE_ID);
		
			pstmt.setInt(1,pageId);

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
