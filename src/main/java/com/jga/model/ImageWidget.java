package com.jga.model;

public class ImageWidget extends Widget {
	public ImageWidget(String name, Integer width, Integer height, String cssClass, String cssStyle, String text,
			Integer order, String src) {
		super(name, width, height, cssClass, cssStyle, text, order, src);
		this.src = src;
		// TODO Auto-generated constructor stub
	}
	private int id;
	private String src;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	
}
