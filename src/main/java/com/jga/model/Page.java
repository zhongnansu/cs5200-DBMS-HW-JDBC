package com.jga.model;

import java.sql.Date;
import java.util.Collection;

public class Page {
	private int id;
	private String title;
	private String description;
	private Date created;
	private Date updated;
	private Integer views;
	private Collection<Widget> widgets;
	
	

	public Page(String title, String description, Date created, Date updated, Integer views, int id) {
		super();
		this.title = title;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.views = views;
		this.id = id;
	}
	
	public Page() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}
	public Collection<Widget> getWidgets() {
		return widgets;
	}
	public void setWidgets(Collection<Widget> widgets) {
		this.widgets = widgets;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
