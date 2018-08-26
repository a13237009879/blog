package com.blog.server.client;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * dubbo服务启动
 * @author admin
 *
 */
public class DubboService {

	private DubboService()
	{
		
	}
	
	/**
	 * 启动dubbo服务
	 * @param springConfPath
	 */
	public static void start(String springConfPath)
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(springConfPath);
		context.start();
		try 
		{
			System.in.read();
		} catch (IOException e) 
		{
			e.printStackTrace();
			context.close();
		}
	}
}
