package com.blog.server.model;

import com.lzl.base.model.BaseModel;
/**
 * 文章内容
 * @author admin
 *
 */
public class Content  extends BaseModel<Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4948037449972449294L;
    /**
     * 文章内容
     */
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
