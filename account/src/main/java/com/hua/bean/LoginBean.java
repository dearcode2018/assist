/**
  * @filename LoginBean.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.bean;

import com.hua.bean.common.BaseBean;

 /**
 * @type LoginBean
 * @description  
 * @author qianye.zheng
 */
public final class LoginBean extends BaseBean
{
	private static final long serialVersionUID = 1L;

	/* 用户名(登录帐号) */
	private String username;
	
	/* 密码 */
	private String password;
	
	/* 类型 */
	private String type;

	/**
	 * @return the username
	 */
	public String getUsername()
	{
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * @return the type
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type)
	{
		this.type = type;
	}
	
}
