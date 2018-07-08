package com.myapp.models.web;

public class Greeting {

	private long id;
	private String content;

	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return " " + id + " : " + content + " ";
	}
}