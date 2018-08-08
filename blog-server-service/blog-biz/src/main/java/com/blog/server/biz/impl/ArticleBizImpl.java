package com.blog.server.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.servcer.mapper.ArticleMapper;
import com.blog.servcer.mapper.ContentMapper;
import com.blog.servcer.redis.RedisUtil;
import com.blog.server.biz.ArticleBiz;
import com.blog.server.biz.TagBiz;
import com.blog.server.client.dto.ArticleDetailDto;
import com.blog.server.exception.BlogException;
import com.blog.server.model.Article;
import com.blog.server.model.Content;
import com.blog.server.model.Tag;
import com.lzl.base.biz.impl.BaseBizImpl;
import com.lzl.base.utils.BasePropertiesInitail;
/**
 * 文章业务逻辑处理实现
 * @author admin
 *
 */
@Service
public class ArticleBizImpl extends BaseBizImpl<ArticleMapper, Article,Integer> implements ArticleBiz{
    
	@Autowired
	private ContentMapper contentMapper;
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private TagBiz tagBiz;
	
	@Override
	public List<Article> queryHotArticle(Integer count) 
	{
		return null;
	}

	@Override
	public boolean saveArticle(ArticleDetailDto articleDto) 
	{
		if (articleDto == null)
		{
			throw new BlogException("文章数据为空，无法进行保存!");
		}
		Article article = articleDto.getArticle();
		if (article == null)
		{
			throw new BlogException("文章数据为空，无法进行保存!");
		}
		// 文章内容处理
		Content content = new Content();
	    BasePropertiesInitail.initBaseModel(content, null);
	    content.setContent(articleDto.getContent());
	    contentMapper.insert(content);
	    // 文章基本信息处理
		BasePropertiesInitail.initBaseModel(article, null);
		article.setbCId(content.getId());
		article.setState(1);
	    mapper.insert(article);
	    // 文章标签处理
	    List<Tag> tags = articleDto.getTags();
	    if (tags == null || tags.isEmpty())
	    {
	    	return true;
	    }
		return false;
	}

	@Override
	public boolean updateArticle(ArticleDetailDto article) 
	{
		
		return false;
	}

	@Override
	public boolean addPraiseNum(String articleId, String userId) 
	{
		return false;
	}

	@Override
	public boolean addReadingVolume(String articleId) 
	{
		return false;
	}

	@Override
	public boolean pushArticle(ArticleDetailDto article) 
	{
		return false;
	}

}
