package com.jga.model;

import java.sql.Date;
import java.util.Collection;

public class Developer extends Person {
	private int id;
	private String developerKey;
	private Collection<Website> websites;
	private Collection<Priviledge> previledge;
	private Collection<String> string;
	private String phone;
	private String Address;
	
	public String toString() {
		return id + " " + developerKey + " " + this.getFirstName();
	}

	 
	
	public Developer(String firstName, String lastName, String username, String password, String email,
			int id, String developerKey) {
		super(firstName, lastName, username, password, email);
		this.id = id;
		this.developerKey = developerKey;
	}
	public Developer() {
		// TODO Auto-generated constructor stub
	}
	public String getDeveloperKey() {
		return developerKey;
	}
	public void setDeveloperKey(String developerKey) {
		this.developerKey = developerKey;
	}
	public Collection<Priviledge> getPreviledge() {
		return previledge;
	}
	public void setPreviledge(Collection<Priviledge> previledge) {
		this.previledge = previledge;
	}
	public Collection<String> getRole() {
		return string;
	}
	public void setRole(Collection<String> string) {
		this.string = string;
	}
	public Collection<Website> getWebsites() {
		return websites;
	}
	public void setWebsites(Collection<Website> websites) {
		this.websites = websites;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getAddress() {
		return Address;
	}



	public void setAddress(String address) {
		Address = address;
	}

	
	

	
}
