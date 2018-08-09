package com.blog.server.exception;
/**
 * 博客异常
 * @author admin
 *
 */
public class BlogException extends Throwable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8029819248832798622L;

	public BlogException(String message, Throwable cause) {
		super(message, cause);
	}

	public BlogException(String message) {
		super(message);
	}

	public BlogException(Throwable cause) {
		super(cause);
	}
}
