package com.sf.xx.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.blog.server.client.dto.ResultMessageDto;
import com.sf.xx.exception.ErrorPageException;
import com.sf.xx.exception.ResultMessageException;
/**
 * 统一处理类
 * @author admin
 *
 */
@ControllerAdvice
public class ExceptionHandleAdvice 
{
	/**
	 * 日志打印
	 */
	private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandleAdvice.class);

	 /**
	  * 处理抛出该异常跳转至错误页面
	  * @param exception
	  * @return
	  */
	 @ExceptionHandler(value = ErrorPageException.class)
	 public ModelAndView errorPageException(ErrorPageException exception)
	 {
		 ModelAndView modelAndView = new ModelAndView("error");
		 modelAndView.addObject("message", exception.getMessage());
		 return modelAndView;
	 }
	 
	 /**
	  * 抛出该异常返回错误信息jsonStr
	  * @param exception
	  * @return
	  */
	 @ResponseBody  
	 @ExceptionHandler(value = ResultMessageException.class)
	 public <T> ResultMessageDto<T> resultMessageException(ResultMessageException exception)
	 {
		 LOG.error(exception.getMessage());
		 return ResultMessageDto.fail(exception.getMessage());
	 }
}
