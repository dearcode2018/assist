/**
 * 描述: 
 * ResultBean.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.bean.common;

import java.io.Serializable;

/**
 * 
 * @type ResultBean
 * @description 响应结果
 * @author qianye.zheng
 */
public final class ResultBean implements Serializable {

	 /* long */
	private static final long serialVersionUID = -5368102181711261710L;
	
	/* 默认 成功 */
	private boolean success = true;
	
	/* 消息编码 */
	private String messageCode = "";
	
	/* 消息 */
	private String message = "";
	
	/* 响应数据 */
	private Object data = "";

	/**
	 * 
	 * @description 构造方法
	 * @author qianye.zheng
	 */
	public ResultBean()
	{
	}

	/**
	 * 
	 * @description 构造方法
	 * @param sucess
	 * @author qianye.zheng
	 */
	public ResultBean(boolean sucess)
	{
		this.success = sucess;
	}

	/**
	 * 
	 * @description 构造方法
	 * @param sucess
	 * @param message
	 * @author qianye.zheng
	 */
	public ResultBean(boolean sucess, String message)
	{
		this.success = sucess;
		this.message = message;
	}
	
	/**
	 * @return the success
	 */
	public final boolean isSuccess()
	{
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public final void setSuccess(boolean success)
	{
		this.success = success;
	}

	/**
	 * @return the messageCode
	 */
	public final String getMessageCode()
	{
		return messageCode;
	}

	/**
	 * @param messageCode the messageCode to set
	 */
	public final void setMessageCode(String messageCode)
	{
		this.messageCode = messageCode;
	}

	/**
	 * @return the message
	 */
	public final String getMessage()
	{
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public final void setMessage(String message)
	{
		this.message = message;
	}

	/**
	 * @return the data
	 */
	public final Object getData()
	{
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public final void setData(Object data)
	{
		this.data = data;
	}

	/**
	 * 
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public String toString()
	{
		return "ResultBean [success=" + success + ", messageCode=" + messageCode + ", message=" + message + ", data=" + data + "]";
	}
}
