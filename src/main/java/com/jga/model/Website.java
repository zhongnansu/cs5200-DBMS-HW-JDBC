package com.jga.model;

import java.sql.Date;
import java.util.Collection;

public class Website {
	private int id;
	private String name;
	private String description;
	private Date created;
	private Date updated;
	private Integer visits;
	private Collection<Page> pages;
	private void addPage() {
		
	}
	private void removePage( ) {
	
	}
	
	
	public Website(String name, String description, Date created, Date updated, Integer visits, int id) {
		super();
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.visits = visits;
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Integer getVisits() {
		return visits;
	}
	public void setVisits(Integer visits) {
		this.visits = visits;
	}
	public Collection<Page> getPages() {
		return pages;
	}
	public void setPages(Collection<Page> pages) {
		this.pages = pages;
	}
	
	
	
}
