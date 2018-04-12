/**
  * @filename AccountList.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.bean;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hua.bean.common.BaseBean;
import com.hua.serializer.DateSerializer;

 /**
 * @type AccountList
 * @description 账户列表
 * @author qianye.zheng
 */
public final class AccountList extends BaseBean
{
	private static final long serialVersionUID = 1L;
	
	/* 来源 */
	private String source;

	/* 登录入口 */
	private String loginLink;
	
	/* 用户名(登录帐号) */
	private String username;

	/* 级别 */
	private String level;
	
	/* 级别名称 */
	private String levelName;
	
	/* 类型 */
	private String type;
	
	/* 类型名称 */
	private String typeName;
	
	/* 有效期至 */
	private Date expireDate;

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
	 * @return the level
	 */
	public final String getLevel()
	{
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public final void setLevel(String level)
	{
		this.level = level;
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
	 * @return the source
	 */
	public final String getSource()
	{
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public final void setSource(String source)
	{
		this.source = source;
	}
	
	/**
	 * @return the expireDate
	 */
	 @JsonSerialize(using = DateSerializer.class)
	public final Date getExpireDate()
	{
		return expireDate;
	}

	/**
	 * @param expireDate the expireDate to set
	 */
	public final void setExpireDate(Date expireDate)
	{
		this.expireDate = expireDate;
	}

	/**
	 * @return the levelName
	 */
	public String getLevelName()
	{
		return levelName;
	}

	/**
	 * @param levelName the levelName to set
	 */
	public void setLevelName(String levelName)
	{
		this.levelName = levelName;
	}

	/**
	 * @return the typeName
	 */
	public String getTypeName()
	{
		return typeName;
	}

	/**
	 * @param typeName the typeName to set
	 */
	public void setTypeName(String typeName)
	{
		this.typeName = typeName;
	}

	/**
	 * @return the loginLink
	 */
	public final String getLoginLink()
	{
		return loginLink;
	}

	/**
	 * @param loginLink the loginLink to set
	 */
	public final void setLoginLink(String loginLink)
	{
		this.loginLink = loginLink;
	}
	
}
