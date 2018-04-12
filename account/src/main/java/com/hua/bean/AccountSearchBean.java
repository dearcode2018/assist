/**
  * @filename AccountSearchBean.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.bean;

import java.util.Date;

import com.hua.bean.common.SearchBean;

 /**
 * @type AccountSearchBean
 * @description 账户搜索参数
 * @author qianye.zheng
 */
public final class AccountSearchBean extends SearchBean
{

	/* 用户名(登录帐号) */
	private String username;

	/* 级别 */
	private String level;
	
	/* 类型 */
	private String type;
	
	/* 来源 */
	private String source;
	
	/* 有效期至(开始) */
	private Date expireDateBegin;
	
	/* 有效期至(结束) */
	private Date expireDateEnd;
	
	/* 创建日期时间(开始) */
	private Date createDateTimeBegin;
	
	/* 创建日期时间(结束) */
	private Date createDateTimeEnd;
	
	/* 更新日期时间(开始) */
	private Date updateDateTimeBegin;
	
	/* 更新日期时间(结束) */
	private Date updateDateTimeEnd;

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
	 * @return the expireDateBegin
	 */
	public final Date getExpireDateBegin()
	{
		return expireDateBegin;
	}

	/**
	 * @param expireDateBegin the expireDateBegin to set
	 */
	public final void setExpireDateBegin(Date expireDateBegin)
	{
		this.expireDateBegin = expireDateBegin;
	}

	/**
	 * @return the expireDateEnd
	 */
	public final Date getExpireDateEnd()
	{
		return expireDateEnd;
	}

	/**
	 * @param expireDateEnd the expireDateEnd to set
	 */
	public final void setExpireDateEnd(Date expireDateEnd)
	{
		this.expireDateEnd = expireDateEnd;
	}

	/**
	 * @return the createDateTimeBegin
	 */
	public final Date getCreateDateTimeBegin()
	{
		return createDateTimeBegin;
	}

	/**
	 * @param createDateTimeBegin the createDateTimeBegin to set
	 */
	public final void setCreateDateTimeBegin(Date createDateTimeBegin)
	{
		this.createDateTimeBegin = createDateTimeBegin;
	}

	/**
	 * @return the createDateTimeEnd
	 */
	public final Date getCreateDateTimeEnd()
	{
		return createDateTimeEnd;
	}

	/**
	 * @param createDateTimeEnd the createDateTimeEnd to set
	 */
	public final void setCreateDateTimeEnd(Date createDateTimeEnd)
	{
		this.createDateTimeEnd = createDateTimeEnd;
	}

	/**
	 * @return the updateDateTimeBegin
	 */
	public final Date getUpdateDateTimeBegin()
	{
		return updateDateTimeBegin;
	}

	/**
	 * @param updateDateTimeBegin the updateDateTimeBegin to set
	 */
	public final void setUpdateDateTimeBegin(Date updateDateTimeBegin)
	{
		this.updateDateTimeBegin = updateDateTimeBegin;
	}

	/**
	 * @return the updateDateTimeEnd
	 */
	public final Date getUpdateDateTimeEnd()
	{
		return updateDateTimeEnd;
	}

	/**
	 * @param updateDateTimeEnd the updateDateTimeEnd to set
	 */
	public final void setUpdateDateTimeEnd(Date updateDateTimeEnd)
	{
		this.updateDateTimeEnd = updateDateTimeEnd;
	}
	
}
