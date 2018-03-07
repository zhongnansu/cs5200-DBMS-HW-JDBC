package com.jga.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.jga.model.Widget;


public class WidgetDao extends BaseDao {
	final String INSERT_WIDGET = "INSERT INTO Widget (name, width, height, cssClass, cssStyle, text, pageId, url, `order`) VALUES (?,?,?,?,?,?,?,?,?)";
	final String SELECT_ALL_WIDGETS = "SELECT * FROM Widget";
	final String SELECT_WIDGET_BY_ID = "SELECT * FROM Widget WHERE id = ?";
	final String SELECT_BY_PAGE_ID = "SELECT * FROM Widget WHERE pageId=?";
	final String UPDATE_BY_ID = "UPDATE Page SET name=?, width=?, height=?, cssClass=?, cssStyle=?, text=?, order=? WHERE id=?";	
	final String DELETE_BY_WIDGET_ID = "DELETE FEOM Widget WHERE id=?";
	
	private static WidgetDao instance;
	private WidgetDao() {};
	public static WidgetDao getInstance() {
		if (instance == null) {
			instance = new WidgetDao();
		}
		return instance;
	}
	
	
 	public int createWidgetForPage(int pageId, Widget widget) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(INSERT_WIDGET);
	
	
			pstmt.setString(1, widget.getName());
			pstmt.setObject(2, widget.getWidth());
			pstmt.setObject(3, widget.getHeight());
			pstmt.setString(4, widget.getCssClass());
			pstmt.setString(5, widget.getCssStyle());
			pstmt.setString(6, widget.getText());
			pstmt.setInt(7, pageId);
			pstmt.setString(8, widget.getUrl());
			pstmt.setInt(9, widget.getOrder());
			
	
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
	
	public Collection<Widget> findAllWidgets() {
		Collection<Widget> widgets = new ArrayList<>();
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(SELECT_ALL_WIDGETS);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				String name = res.getString("name");
				Integer width = res.getInt("width");
				Integer height = res.getInt("height");
				String cssClass = res.getString("cssClass");
				String cssStyle = res.getString("cssStyle");
				String text = res.getString("text");
				Integer order = res.getInt("order");
				String url = res.getString("url");
				
				Widget w = new Widget(name, width, height, cssClass, cssStyle, text, order, url);
				widgets.add(w);
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
		return widgets;
	}
	
	public Widget findWidgetById(int widgetId) {
		Widget p = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(SELECT_WIDGET_BY_ID);
			pstmt.setInt(1, widgetId);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				String name = res.getString("name");
				Integer width = res.getInt("width");
				Integer height = res.getInt("height");
				String cssClass = res.getString("cssClass");
				String cssStyle = res.getString("cssStyle");
				String text = res.getString("text");
				Integer order = res.getInt("order");
				String url = res.getString("url");
				
				p = new Widget(name, width, height, cssClass, cssStyle, text, order, url);
				
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
	
	public Collection<Widget> findWidgetsForPage(int pageId) {
		Collection<Widget> widgets = new ArrayList<>();
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(SELECT_BY_PAGE_ID);
			pstmt.setInt(1, pageId);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				String name = res.getString("name");
				Integer width = res.getInt("width");
				Integer height = res.getInt("height");
				String cssClass = res.getString("cssClass");
				String cssStyle = res.getString("cssStyle");
				String text = res.getString("text");
				Integer order = res.getInt("order");
				
				String url = res.getString("url");
				
				Widget w = new Widget(name, width, height, cssClass, cssStyle, text, order, url);
				widgets.add(w);
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
		return widgets;
	}
	
	
	public int updateWidget(int widgetId, Widget widget) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(UPDATE_BY_ID);
		
			
			pstmt.setInt(1, widget.getWidth());
			pstmt.setInt(2, widget.getHeight());
			pstmt.setString(3, widget.getCssClass());
			pstmt.setString(4, widget.getCssStyle());
			pstmt.setString(5, widget.getText());
			pstmt.setInt(6, widget.getOrder());
			pstmt.setInt(7, widgetId);
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
	
	public int deleteWidget(int widgetId) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(DELETE_BY_WIDGET_ID);
		
			pstmt.setInt(1,widgetId);

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
