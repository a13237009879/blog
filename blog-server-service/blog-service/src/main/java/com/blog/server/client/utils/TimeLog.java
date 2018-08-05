package com.blog.server.client.utils;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 运行时间记录
 * @author admin
 *
 */
public class TimeLog 
{
    private static final Logger LOG = LoggerFactory.getLogger(TimeLog.class);
	private Date startTime;
	private TimeLog() {

	}

	public static TimeLog startLog(String message) 
	{
		TimeLog log = new TimeLog();
		log.startTime = new Date();
		LOG.debug(message);
		return log;
	}
	
	public  void endLog(String message)
	{
		Date endTime = new Date();
		LOG.debug(message + ",共耗时:" + (endTime.getTime() - this.startTime.getTime()) / 60*1000 + "秒");
	}
}
