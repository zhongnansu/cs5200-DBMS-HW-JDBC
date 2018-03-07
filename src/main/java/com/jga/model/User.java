package com.jga.model;

public class User extends Person {
	private int id;
	private Boolean userAgreement;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Boolean getUserAgreement() {
		return userAgreement;
	}
	public void setUserAgreement(Boolean userAgreement) {
		this.userAgreement = userAgreement;
	}
	 
	 
	
}
