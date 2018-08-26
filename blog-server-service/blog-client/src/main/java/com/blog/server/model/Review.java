package com.blog.server.model;

import com.lzl.base.model.BaseModel;

public class Review extends BaseModel<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2680325801697723045L;

	private Integer bAId;

	private String message;

	public Integer getbAId() {
		return bAId;
	}

	public void setbAId(Integer bAId) {
		this.bAId = bAId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message == null ? null : message.trim();
	}

}
