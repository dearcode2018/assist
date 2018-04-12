/**
  * @filename AccountRuntimeException.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.exception;

 /**
 * @type AccountRuntimeException
 * @description  
 * @author qianye.zheng
 */
public final class AccountRuntimeException extends RuntimeException
{
	private static final long serialVersionUID = -7766002421000749821L;

	/**
	 * @description 构造方法
	 * @author qianye.zheng
	 */
	public AccountRuntimeException()
	{
	}
	
	/**
	 * 
	 * @description 构造方法
	 * @param message
	 * @author qianye.zheng
	 */
	public AccountRuntimeException(String message)
	{
		super(message);
	}
	
	/**
	 * 
	 * @description 构造方法
	 * @param message
	 * @param cause
	 * @author qianye.zheng
	 */
	public AccountRuntimeException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	/**
	 * 
	 * @description 构造方法
	 * @param cause
	 * @author qianye.zheng
	 */
	public AccountRuntimeException(Throwable cause)
	{
		super( cause);
	}
}
