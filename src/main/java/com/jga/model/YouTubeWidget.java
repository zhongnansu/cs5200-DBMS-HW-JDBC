package com.jga.model;

public class YouTubeWidget extends Widget {
	public YouTubeWidget(String name, Integer width, Integer height, String cssClass, String cssStyle, String text,
			Integer order, String url) {
		super(name, width, height, cssClass, cssStyle, text, order, url);
		this.url = url;
		// TODO Auto-generated constructor stub
	}
	private int id;
	private String url;
	private Boolean shareble;
	private Boolean expandable;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Boolean getShareble() {
		return shareble;
	}
	public void setShareble(Boolean shareble) {
		this.shareble = shareble;
	}
	public Boolean getExpandable() {
		return expandable;
	}
	public void setExpandable(Boolean expandable) {
		this.expandable = expandable;
	}

	
	
	
	
}
