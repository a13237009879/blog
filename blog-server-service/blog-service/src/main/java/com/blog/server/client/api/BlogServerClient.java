package com.blog.server.client.api;

import com.blog.server.client.api.utils.TimeLog;

public class BlogServerClient 
{
   public static void main(String[] args) 
   {
	   TimeLog log = TimeLog.startLog("BlogServerClient正在启动...");
	   DubboService.start("classpath*:spring/*.xml");
	   log.endLog("BlogServerClient启动结束...");
   }
}
