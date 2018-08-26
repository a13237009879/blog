package com.sf.xx.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.server.client.api.ArticleRpcClient;
import com.blog.server.client.dto.ArticleDetailDto;
import com.blog.server.client.dto.ResultMessageDto;
import com.blog.server.model.Article;
import com.reger.dubbo.annotation.Inject;

@RestController
@RequestMapping("/article")
public class ArticleController 
{
   @Inject
   private ArticleRpcClient articleRpcClient;
   
   /**
    * 分页查找文章集合
    * @return
    */
   @RequestMapping(value="/list")
   public ResultMessageDto<List<Article>> queryHotArticle()
   {
	   return articleRpcClient.queryHotArticle(10);
   }
   
   /**
    * 查找文章通过ID
    * @param id
    * @return
    */
   @RequestMapping(value="/{id}")
   public ResultMessageDto<ArticleDetailDto> findOne(@PathParam(value="articleId")Integer articleId)
   {
	   return articleRpcClient.queryArticleDetailById(articleId);
   }
   
   /**
    * 插入文章信息
    * @param po
    * @return
    */
   @RequestMapping("/insert")
   public ResultMessageDto<Boolean> insert(ArticleDetailDto article)
   {
	   return articleRpcClient.pushArticle(article);
   }
   
   /**
    * 更新文章信息
    * @param po
    * @return
    */
   @RequestMapping("/update")
   public ResultMessageDto<Boolean> update(ArticleDetailDto article)
   {
	   return articleRpcClient.updateArticle(article);
   }
   
}
