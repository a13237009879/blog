package com.blog.server.client.dto;

/**
 * 数据返回对象
 * @author admin
 *
 */
public class ResultMessageDto<T> {
	// 提示信息
	private String message;
    // 是否成功
	private boolean resultBol;
    // 传输数据
	private T data;
	// 失败
	private transient static final boolean FAIL = false;
	// 成功
	private transient static final boolean TRUE = true;

	private ResultMessageDto() {

	}

	private ResultMessageDto(String message, boolean flag, T data) {
		this.setMessage(message);
		this.setResultBol(flag);
		this.setData(data);
	}

	/**
	 * 不带提示信息的成功数据对象
	 * 
	 * @return
	 */
	public static <T> ResultMessageDto<T> ok(T data) {
		return ok("", data);
	}

	/**
	 * 带提示信息的成功数据对象
	 * 
	 * @param message
	 * @param data
	 * @return
	 */
	public static <T> ResultMessageDto<T> ok(String message, T data) {
		return new ResultMessageDto<>(message, TRUE, data);
	}
	
	/**
	 * 带提示信息的失败数据对象
	 * @param message
	 * @param data
	 * @return
	 */
	public static <T> ResultMessageDto<T> fail(String message, T data) {
		return new ResultMessageDto<>(message, FAIL, data);
	}
	
	public static <T> ResultMessageDto<T> fail(String message) {
		return new ResultMessageDto<>(message, FAIL, null);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean isResultBol() {
		return resultBol;
	}

	public void setResultBol(boolean resultBol) {
		this.resultBol = resultBol;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
