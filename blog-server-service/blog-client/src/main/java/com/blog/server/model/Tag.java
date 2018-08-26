package com.blog.server.model;

import com.lzl.base.model.BaseModel;

/**
 * 文章分类
 * 
 * @author admin
 *
 */
public class Tag extends BaseModel<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5528840702379195767L;

	private String tagName;

	private Integer tagCode;

	private String tagIcon;

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName == null ? null : tagName.trim();
	}

	public Integer getTagCode() {
		return tagCode;
	}

	public void setTagCode(Integer tagCode) {
		this.tagCode = tagCode;
	}

	public String getTagIcon() {
		return tagIcon;
	}

	public void setTagIcon(String tagIcon) {
		this.tagIcon = tagIcon == null ? null : tagIcon.trim();
	}

}
