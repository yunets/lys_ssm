package com.yun.common.exception;

/**
 * <p>Title: ValidateException</p>
 * <p>Description:验证异常. </p>
 * <p>Company: 天人环境˾</p>
 * @author    Wangxu
 * @version   v1.0
 */
public class ValidateException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6453906604021603562L;

	public ValidateException(String str){
        super(str);
    }
}
