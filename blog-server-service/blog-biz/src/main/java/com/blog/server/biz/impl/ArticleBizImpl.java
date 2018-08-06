package com.blog.server.biz.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.servcer.mapper.ArticleMapper;
import com.blog.server.biz.ArticleBiz;
import com.blog.server.model.Article;
import com.lzl.base.biz.impl.BaseBizImpl;
/**
 * 文章业务逻辑处理实现
 * @author admin
 *
 */
@Service
public class ArticleBizImpl extends BaseBizImpl<ArticleMapper, Article,Integer> implements ArticleBiz{

	@Override
	public List<Article> queryHotArticle(Integer count) {
		return null;
	}

}
