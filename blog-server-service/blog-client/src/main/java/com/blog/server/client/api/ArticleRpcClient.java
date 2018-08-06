package com.blog.server.client.api;
/**
 * 文章RPC服务接口
 * @author admin
 *
 */

import java.util.List;

import com.blog.server.client.dto.ArticleDetailDto;
import com.blog.server.client.dto.ResultMessageDto;
import com.blog.server.model.Article;
/**
 * 文章RPC服务
 * @author admin
 *
 */
public interface ArticleRpcClient 
{
   /**
    * 获取热度前count的文章
    * @param count
    * @return
    */
   public ResultMessageDto<List<Article>> queryHotArticle(Integer count);

   /**
    * 通过当前选择的文章获取文章内容详情
    * @param articleId
    * @return
    */
   public ResultMessageDto<ArticleDetailDto> queryArticleDetailById(Integer articleId);

} 
