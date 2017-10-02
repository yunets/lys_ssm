package com.yun.common.exception;

/**
 * Dao层异常信息 <br>
 * Company:天人环境<br>
 * @author WangXu<br>
 * @version Revision: 1.0
 */
public class DaoException extends RuntimeException {

	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = 8350049272861703406L;

	public DaoException() {
		super();
	}

	public DaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

}
