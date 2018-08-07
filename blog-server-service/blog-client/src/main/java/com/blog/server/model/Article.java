package com.blog.server.model;

import java.util.Date;

import com.lzl.base.model.BaseModel;

/**
 * 博客文章对象
 * @author admin
 *
 */
public class Article extends BaseModel<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7240337554672520272L;
	/**
	 * 文章内容ID
	 */
	private Integer bCId;
	/**
	 * 文章标题
	 */
	private String title;
	/**
	 * 文章摘要
	 */
	private String bAbstract;
	/**
	 * 文章图片地址
	 */
	private String pictures;
	/**
	 * 发布时间
	 */
	private Date releaseDate;
	/**
	 * 文章状态 1:草稿 2:发布
	 */
	private Integer state;

	public Integer getbCId() {
		return bCId;
	}

	public void setbCId(Integer bCId) {
		this.bCId = bCId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getbAbstract() {
		return bAbstract;
	}

	public void setbAbstract(String bAbstract) {
		this.bAbstract = bAbstract;
	}

	public String getPictures() {
		return pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
}
