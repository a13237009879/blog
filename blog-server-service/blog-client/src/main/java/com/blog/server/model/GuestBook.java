package com.blog.server.model;

import com.lzl.base.model.BaseModel;

public class GuestBook extends BaseModel<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 100185437449710986L;

	private String name;

	private String message;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message == null ? null : message.trim();
	}
}
