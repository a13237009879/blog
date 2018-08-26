package com.blog.server.client.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blog.server.biz.ArticleBiz;
import com.blog.server.client.api.ArticleRpcClient;
import com.blog.server.client.dto.ArticleDetailDto;
import com.blog.server.client.dto.ResultMessageDto;
import com.blog.server.exception.BlogException;
import com.blog.server.model.Article;
/**
 * 文章RPC服务实现类
 * @author admin
 *
 */
public class ArticleRpcClientImpl implements ArticleRpcClient
{
	@Autowired
	private ArticleBiz articleBiz;

	@Override
	public ResultMessageDto<List<Article>> queryHotArticle(Integer count) {
		return ResultMessageDto.ok(articleBiz.queryHotArticle(count));
	}

	@Override
	public ResultMessageDto<ArticleDetailDto> queryArticleDetailById(Integer articleId) {
		try 
		{
			ArticleDetailDto result = articleBiz.queryArticleDetailById(articleId);
			return ResultMessageDto.ok(result);
		} catch (BlogException e) 
		{
			return ResultMessageDto.fail(e.getMessage());
		}
	}

	@Override
	public ResultMessageDto<Boolean> saveArticle(ArticleDetailDto article) {
		try 
		{
			return ResultMessageDto.ok(articleBiz.saveArticle(article));
		} catch (BlogException e) 
		{
			return ResultMessageDto.fail(e.getMessage());
		}
	}

	@Override
	public ResultMessageDto<Boolean> pushArticle(ArticleDetailDto article) {
		try 
		{
			return ResultMessageDto.ok(articleBiz.pushArticle(article));
		} catch (BlogException e) 
		{
			return ResultMessageDto.fail(e.getMessage());
		}
	}

	@Override
	public ResultMessageDto<Boolean> updateArticle(ArticleDetailDto article) {
		try 
		{
			return ResultMessageDto.ok(articleBiz.updateArticle(article));
		} catch (BlogException e) 
		{
			return ResultMessageDto.fail(e.getMessage());
		}
	}

	@Override
	public ResultMessageDto<Double> addPraiseNum(String articleId) 
	{
		try 
		{
			return ResultMessageDto.ok(articleBiz.addPraiseNum(articleId));
		} catch (BlogException e) 
		{
			return ResultMessageDto.fail(e.getMessage());
		}
	}

	@Override
	public ResultMessageDto<Double> addReadingVolume(String articleId) 
	{
		return ResultMessageDto.ok(articleBiz.addReadingVolume(articleId));
	}

	@Override
	public ResultMessageDto<List<Article>> queryHotArticleByTag(String tagId) {
		return null;
	}
    
}
