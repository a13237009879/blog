package com.blog.server.client.dto;

import java.io.Serializable;
import java.util.List;

import com.blog.server.model.Article;
import com.blog.server.model.Tag;
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
    /**
     * 文章基本信息
     */
	private Article article;
	/**
	 * 所属分类
	 */
	private List<Tag> tags;
    /**
     * 文章内容
     */
	private String content;
    /**
     * 文章点赞数
     */
	private Long praiseNum;
	/**
	 * 文章阅读量
	 */
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

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

}
