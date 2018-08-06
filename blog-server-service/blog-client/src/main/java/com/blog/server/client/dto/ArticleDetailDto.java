package com.blog.server.client.dto;

import java.io.Serializable;

import com.blog.server.model.Article;
/**
 * 文章数据传输对象
 * @author admin
 *
 */
public class ArticleDetailDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2218595144745234160L;

	private Article article;

	private String content;

	private Long praiseNum;

	private Long readingVolume;

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(Long praiseNum) {
		this.praiseNum = praiseNum;
	}

	public Long getReadingVolume() {
		return readingVolume;
	}

	public void setReadingVolume(Long readingVolume) {
		this.readingVolume = readingVolume;
	}

}
