package com.blog.server.biz.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.server.biz.ArticleBiz;
import com.blog.server.biz.TagBiz;
import com.blog.server.client.dto.ArticleDetailDto;
import com.blog.server.exception.BlogException;
import com.blog.server.mapper.ArticleMapper;
import com.blog.server.mapper.ContentMapper;
import com.blog.server.model.Article;
import com.blog.server.model.Content;
import com.blog.server.redis.RedisUtil;
import com.blog.server.utils.RedisKey;
import com.lzl.base.biz.impl.BaseBizImpl;
import com.lzl.base.utils.BasePropertiesInitail;
/**
 * 文章业务逻辑处理实现
 * @author admin
 *
 */
@Service
public class ArticleBizImpl extends BaseBizImpl<ArticleMapper, Article,Integer> implements ArticleBiz
{
    private static final Logger LOG = LoggerFactory.getLogger(ArticleBizImpl.class);
	@Autowired
	private ContentMapper contentMapper;
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private TagBiz tagBiz;
	
	@Override
	public List<Article> queryHotArticle(Integer count) 
	{
		// 计算热点值
		redisUtil.intersectAndStore(RedisKey.ARTICLE_PRAISE_NUM_KEY, RedisKey.ARTICLE_PUSH_TIME_KEY, RedisKey.HOT_KEY);
		Set<Object> articleIds = redisUtil.reverseRange(RedisKey.HOT_KEY, 0, count);
		return mapper.queryArticleByIds(articleIds);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public boolean saveArticle(ArticleDetailDto articleDto) throws BlogException 
	{
		if (articleDto == null)
		{
			LOG.error("文章数据为空，无法进行保存!");
			throw new BlogException("文章数据为空，无法进行保存!");
		}
		Article article = articleDto.getArticle();
		if (article == null)
		{
			LOG.error("文章数据为空，无法进行保存!");
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
	    tagBiz.saveBatchTag(articleDto.getTags(), article.getId());
	    return true;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public boolean updateArticle(ArticleDetailDto articleDto) throws BlogException  
	{
		if (articleDto == null)
		{
			LOG.error("文章数据为空，无法进行更新!");
			throw new BlogException("文章数据为空，无法进行更新!");
		}
		Article article = articleDto.getArticle();
		if (article == null)
		{
			LOG.error("文章数据为空，无法进行更新!");
			throw new BlogException("文章数据为空，无法进行更新!");
		}
		// 文章内容处理
		Content content = new Content();
		content.setUpdateTime(new Date());
		content.setUpdateUser(null);
	    content.setContent(articleDto.getContent());
	    contentMapper.updateByPrimaryKeySelective(content);
	    mapper.updateByPrimaryKeySelective(article);
	    // 文章标签处理
	    tagBiz.saveBatchTag(articleDto.getTags(), article.getId());
		return false;
	}

	@Override
	public Double addPraiseNum(String articleId) throws BlogException 
	{
		if (redisUtil.isMember(RedisKey.ARTICLE_PRAISE_NUM_USER_KEY + articleId,null))
		{
			throw new BlogException("你已经对这篇文章点过赞了!");
		}
		// 增加一个点赞数
		return redisUtil.incrementScore(RedisKey.ARTICLE_PRAISE_NUM_KEY, articleId, 432);
	}

	@Override
	public Double addReadingVolume(String articleId) 
	{
		return redisUtil.incrementScore(RedisKey.ARTICLE_READVOL_KEY, articleId, 1);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public boolean pushArticle(ArticleDetailDto articleDto) throws BlogException  
	{
		Article article = articleDto.getArticle();
		Integer state = article.getState();
		if (state == 2)
		{
			throw new BlogException("该文章已经发布了!");
		}
		article.setState(2);
		Date curDate = new Date();
		article.setReleaseDate(curDate);
		mapper.updateByPrimaryKeySelective(article);
		Integer articleId = article.getId();
		// 增加自己为不可点赞的用户并存储文章发布时间
		redisUtil.sadd(RedisKey.ARTICLE_PRAISE_NUM_USER_KEY + articleId, null);
		redisUtil.add(RedisKey.ARTICLE_PUSH_TIME_KEY, articleId, curDate.getTime());
		return true;
	}

	@Override
	public ArticleDetailDto queryArticleDetailById(Integer articleId) throws BlogException  
	{
		Article article = mapper.selectByPrimaryKey(articleId);
		if (article == null)
		{
			LOG.error("文章ID为" + articleId + "的文章记录丢失!");
			throw new BlogException("文章记录丢失!");
		}
		// 获取文章内容信息
		Content content = contentMapper.selectByPrimaryKey(article.getbCId());
		// 获取文章点赞信息
		Double pariseNum = redisUtil.score(RedisKey.ARTICLE_PRAISE_NUM_KEY, articleId);
		Double readVol = redisUtil.score(RedisKey.ARTICLE_READVOL_KEY, articleId);
		// 文章对应的分类标签
		
		ArticleDetailDto result = new ArticleDetailDto();
		result.setArticle(article);
		result.setContent(content.getContent());
		result.setPraiseNum(Long.parseLong((pariseNum / 432) + ""));
		result.setPraiseNum(Long.parseLong(readVol + ""));
		return result;
	}
}
