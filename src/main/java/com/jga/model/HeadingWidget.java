package com.jga.model;

public class HeadingWidget extends Widget {
	public HeadingWidget(String name, Integer width, Integer height, String cssClass, String cssStyle, String text,
			Integer order) {
		super(name, width, height, cssClass, cssStyle, text, order, null);
		// TODO Auto-generated constructor stub
	}
	private int id;
	private Integer size;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	
}
