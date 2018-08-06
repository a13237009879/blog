package com.blog.server.client.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blog.server.biz.ArticleBiz;
import com.blog.server.client.api.ArticleRpcClient;
import com.blog.server.client.dto.ArticleDetailDto;
import com.blog.server.client.dto.ResultMessageDto;
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
		return null;
	}
    
}
