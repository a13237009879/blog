package com.blog.server.biz;

import java.util.List;

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
	List<Article> queryHotArticle(Integer count);
}
