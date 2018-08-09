package com.blog.server.client.api;

import java.util.List;
import com.blog.server.client.dto.ArticleDetailDto;
import com.blog.server.client.dto.ResultMessageDto;
import com.blog.server.model.Article;
/**
 * 文章RPC服务接口
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
    * 通过分类查找热门文章
    * @param tagId
    * @return
    */
   public ResultMessageDto<List<Article>> queryHotArticleByTag(String tagId);
   
   /**
    * 通过当前选择的文章获取文章内容详情
    * @param articleId
    * @return
    */
   public ResultMessageDto<ArticleDetailDto> queryArticleDetailById(Integer articleId);
   
	/**
	 * 保存文章
	 * @return
	 */
	public ResultMessageDto<Boolean> saveArticle(ArticleDetailDto article);
	
	/**
	 * 发布文章
	 * @param article
	 * @return
	 */
	public ResultMessageDto<Boolean> pushArticle(ArticleDetailDto article);
	
	/**
	 * 修改文章
	 * @param article
	 * @return
	 */
	public ResultMessageDto<Boolean> updateArticle(ArticleDetailDto article);
	
	/**
	 * 点赞操作
	 * @return
	 */
	public ResultMessageDto<Double> addPraiseNum(String articleId);
	
	/**
	 * 阅读量增加
	 * @param articleId
	 * @return
	 */
	public ResultMessageDto<Double> addReadingVolume(String articleId);

} 
