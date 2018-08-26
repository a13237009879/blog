package com.sf.xx.exception;
/**
 * 返回信息异常
 * @author admin
 *
 */
public class ResultMessageException extends IllegalArgumentException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 735728236784667797L;

	public ResultMessageException() 
	{
		super();
	}

	public ResultMessageException(String message, Throwable cause) 
	{
		super(message, cause);
	}

	public ResultMessageException(String message) 
	{
		super(message);
	}
	
	

}
