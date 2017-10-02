package com.yun.common.exception;

import org.springframework.dao.DataAccessException;

/**
 * @ClassName DataProcessException<br>
 * @Description 访问数据时异常，在数据查找、更新出错时抛出<br>
 * @Company 天人环境<br>
 * @author WangXu<br>
 * @version V1.0<br>
 */
public class DataProcessException extends DataAccessException {

	private static final long serialVersionUID = 1L;

	private String message;

	/**
	 * 构造器
	 * 
	 * @param
	 */
	public DataProcessException(String message) {
		super(message);
		this.message = message;
	}

	/**
	 * 返回处理好的错误提示信息
	 */
	@Override
	public String toString() {
		return this.message;
	}
}
