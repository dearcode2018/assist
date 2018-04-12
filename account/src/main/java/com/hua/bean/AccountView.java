/**
  * @filename AccountView.java
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
 * @type AccountView
 * @description 账户视图
 * @author qianye.zheng
 */
public final class AccountView extends BaseBean
{
	private static final long serialVersionUID = 1L;

	/* 用户名(登录帐号) */
	private String username;
	
	/* 密码 */
	private String password;

	/* 级别 */
	private String level;
	
	/* 类型 */
	private String type;
	
	/* 来源 */
	private String source;
	
	/* 用途 */
	private String usage;
	
	/* 关联帐号 */
	private String relationalAccounts;
	
	/* 有效期至 */
	private Date expireDate;
	
	/* 手机号码 */
	private String mobilePhone;
	
	/* 官网 */
	private String officialLink;
	
	/* 登录入口 */
	private String loginLink;
	
	/* 位置信息 */
	private String location;

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
	 * @return the password
	 */
	public final String getPassword()
	{
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public final void setPassword(String password)
	{
		this.password = password;
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
	 * @return the usage
	 */
	public final String getUsage()
	{
		return usage;
	}

	/**
	 * @param usage the usage to set
	 */
	public final void setUsage(String usage)
	{
		this.usage = usage;
	}

	/**
	 * @return the relationalAccounts
	 */
	public final String getRelationalAccounts()
	{
		return relationalAccounts;
	}

	/**
	 * @param relationalAccounts the relationalAccounts to set
	 */
	public final void setRelationalAccounts(String relationalAccounts)
	{
		this.relationalAccounts = relationalAccounts;
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
	 * @return the mobilePhone
	 */
	public final String getMobilePhone()
	{
		return mobilePhone;
	}

	/**
	 * @param mobilePhone the mobilePhone to set
	 */
	public final void setMobilePhone(String mobilePhone)
	{
		this.mobilePhone = mobilePhone;
	}

	/**
	 * @return the officialLink
	 */
	public final String getOfficialLink()
	{
		return officialLink;
	}

	/**
	 * @param officialLink the officialLink to set
	 */
	public final void setOfficialLink(String officialLink)
	{
		this.officialLink = officialLink;
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

	/**
	 * @return the location
	 */
	public final String getLocation()
	{
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public final void setLocation(String location)
	{
		this.location = location;
	}
	
	
}
