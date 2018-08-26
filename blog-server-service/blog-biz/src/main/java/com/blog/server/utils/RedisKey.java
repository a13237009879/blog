package com.blog.server.utils;
/**
 * redis键常量
 * @author admin
 *
 */
public class RedisKey 
{
	private RedisKey()
	{
		
	}
	
	/**
	 * 已点赞文章的用户记录key
	 */
   public static final String ARTICLE_PRAISE_NUM_USER_KEY = "praiseNum:user:";
   /**
    * 文章点赞key
    */
   public static final String ARTICLE_PRAISE_NUM_KEY = "praiseNum:";
   /**
    * 文章阅读量
    */
   public static final String ARTICLE_READVOL_KEY = "readvol:";
   /**
    * 文章发布时间key
    */
   public static final String ARTICLE_PUSH_TIME_KEY = "article:pushTime:";
   /**
    * 热点文章key
    */
   public static final String HOT_KEY = "hot:";
}
