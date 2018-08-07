package com.blog.server.biz;

import java.util.List;

import com.blog.server.client.dto.ArticleDetailDto;
import com.blog.server.model.Article;
import com.lzl.base.biz.BaseBiz;
/**
 * 文章管理
 * @author admin
 *
 */
public interface ArticleBiz extends BaseBiz<Article, Integer>
{
	/**
	 * 得到热门的count篇文章
	 * @param count
	 * @return
	 */
	public List<Article> queryHotArticle(Integer count);
	
	/**
	 * 保存文章
	 * @return
	 */
	public boolean saveArticle(ArticleDetailDto article);
	
	/**
	 * 发布文章
	 * @param article
	 * @return
	 */
	public boolean pushArticle(ArticleDetailDto article);
	
	/**
	 * 修改文章
	 * @param article
	 * @return
	 */
	public boolean updateArticle(ArticleDetailDto article);
	
	/**
	 * 点赞操作
	 * @return
	 */
	public boolean addPraiseNum(String articleId, String userId);
	
	/**
	 * 阅读量增加
	 * @param articleId
	 * @return
	 */
	public boolean addReadingVolume(String articleId);
	
	
}
