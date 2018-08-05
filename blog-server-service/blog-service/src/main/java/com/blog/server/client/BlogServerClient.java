package com.blog.server.client;

import com.blog.server.client.utils.TimeLog;

public class BlogServerClient 
{
   public static void main(String[] args) 
   {
	   TimeLog log = TimeLog.startLog("BlogServerClient正在启动...");
	   DubboService.start("classpath:spring/*.xml");
	   log.endLog("BlogServerClient启动结束...");
   }
}
