package com.sf.xx.exception;
/**
 * 跳转错误页面异常
 * @author admin
 *
 */
public class ErrorPageException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8398523232146535397L;

	public ErrorPageException() 
	{
		super();
	}

	public ErrorPageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) 
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ErrorPageException(String message, Throwable cause) 
	{
		super(message, cause);
	}
}
