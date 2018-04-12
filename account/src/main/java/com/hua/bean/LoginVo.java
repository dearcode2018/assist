/**
  * @filename LoginVo.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.bean;

import java.util.Date;

import com.hua.bean.common.BaseBean;

 /**
 * @type LoginVo
 * @description 登录结果
 * @author qianye.zheng
 */
public final class LoginVo extends BaseBean
{
	private static final long serialVersionUID = 1L;

	/* 用户名(登录帐号) */
	private String username;
	
	/* 类型 */
	private String type;
	
	/* 登录次数 */
	private Integer loginCount;
	
	/* 上一次登录日期时间 */
	private Date lastLoginDateTime;

	/**
	 * @return the username
	 */
	public final String getUsername()
	{
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public final void setUsername(String username)
	{
		this.username = username;
	}

	/**
	 * @return the type
	 */
	public final String getType()
	{
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public final void setType(String type)
	{
		this.type = type;
	}

	/**
	 * @return the loginCount
	 */
	public final Integer getLoginCount()
	{
		return loginCount;
	}

	/**
	 * @param loginCount the loginCount to set
	 */
	public final void setLoginCount(Integer loginCount)
	{
		this.loginCount = loginCount;
	}

	/**
	 * @return the lastLoginDateTime
	 */
	public final Date getLastLoginDateTime()
	{
		return lastLoginDateTime;
	}

	/**
	 * @param lastLoginDateTime the lastLoginDateTime to set
	 */
	public final void setLastLoginDateTime(Date lastLoginDateTime)
	{
		this.lastLoginDateTime = lastLoginDateTime;
	}
	
}
