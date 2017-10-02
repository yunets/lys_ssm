package com.yun.common.exception;

/**
 * 控制层异常信息  <br>
 * Company:天人环境<br>
 * @author WangXu<br>
 * @version Revision: 1.0
 */
public class ControllerException extends RuntimeException {

	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = 4081863331832266720L;

	public ControllerException() {
		super();
	}

	public ControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ControllerException(String message, Throwable cause) {
		super(message, cause);
	}

	public ControllerException(String message) {
		super(message);
	}

	public ControllerException(Throwable cause) {
		super(cause);
	}

}
