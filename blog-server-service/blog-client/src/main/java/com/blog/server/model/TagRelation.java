package com.blog.server.model;

import com.lzl.base.model.BaseModel;

public class TagRelation extends BaseModel<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6690050013894723386L;
	/**
	 * 标签ID
	 */
	private Integer tagId;
	/**
	 * 文章ID
	 */
	private Integer articleId;

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
}
