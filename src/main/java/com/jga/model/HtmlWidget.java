package com.jga.model;

public class HtmlWidget extends Widget {
	public HtmlWidget(String name, Integer width, Integer height, String cssClass, String cssStyle, String text,
			Integer order) {
		super(name, width, height, cssClass, cssStyle, text, order, null);
		// TODO Auto-generated constructor stub
	}
	private int id;
	private String html;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	
}
