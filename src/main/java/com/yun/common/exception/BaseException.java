package com.yun.common.exception;

/**
 * <p>Title: BaseException</p>
 * <p>Description: </p>
 * <p>Company: 天人环境</p>
 * @author    Wangxu
 * @version   v1.0
 */
public class BaseException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private Integer code;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public BaseException(Integer code) {

		super();
		this.code = code;

	}

	public BaseException(Integer code, String message) {

		super(message);
		this.code = code;

	}

}
