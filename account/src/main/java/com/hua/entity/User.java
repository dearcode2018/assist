/**
  * @filename User.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.hua.constant.AccountConstant;

 /**
 * @type User
 * @description 用户(系统登录)
 * @author qianye.zheng
 */
@Entity(name = "t_user")
//@Table(name = "t_user")
public final class User
{
	@GenericGenerator(name = "idGenerator", strategy = "native")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id", insertable = true, 
			updatable = false,
			nullable = false, unique = true)
	@Id
	/* 对象唯一id，使用自增长 */
	private Integer id;

	@Column(name = "status", insertable = true, 
			updatable = true,
			nullable = true, unique = false)
	/* 状态: 有效-1，无效-0 */
	private Integer status = AccountConstant.STATUS_VALID;
	
	@Column(name = "remark", insertable = true, 
			updatable = true, length = 1024, 
			nullable = true, unique = false)
	/* 备注 */
	private String remark;
	
	@Column(name = "createDateTime", insertable = true, 
			updatable = false,
			nullable = true, unique = false)
	/* 创建时间 */
	private Date createDateTime;
	
	@Column(name = "updateDateTime", insertable = true, 
			updatable = true,
			nullable = true, unique = false)
	/* 更新时间 */
	private Date updateDateTime;
	
	@Column(name = "username", insertable = true, 
			updatable = false, length = 64, 
			nullable = true, unique = false)
	/* 用户名(登录帐号) */
	private String username;
	
	@Column(name = "password", insertable = true, 
			updatable = true, length = 128, 
			nullable = true, unique = false)
	/* 密码 */
	private String password;
	
	@Column(name = "type", insertable = true, 
			updatable = true, length = 10, 
			nullable = true, unique = false)
	/* 类型 */
	private String type;
	
	@Column(name = "locked", insertable = true, 
			updatable = true,
			nullable = true, unique = false)
	/* 是否锁定, 0-无锁定，1-已锁定 */
	private Integer locked;
	
	@Column(name = "loginCount", insertable = true, 
			updatable = true,
			nullable = true, unique = false)
	/* 登录次数 */
	private Integer loginCount;
	
	@Column(name = "lastLoginDateTime", insertable = true, 
			updatable = true,
			nullable = true, unique = false)
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
	 * @return the locked
	 */
	public final Integer getLocked()
	{
		return locked;
	}

	/**
	 * @param locked the locked to set
	 */
	public final void setLocked(Integer locked)
	{
		this.locked = locked;
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

	/**
	 * @return the id
	 */
	public final Integer getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(Integer id)
	{
		this.id = id;
	}

	/**
	 * @return the status
	 */
	public final Integer getStatus()
	{
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public final void setStatus(Integer status)
	{
		this.status = status;
	}

	/**
	 * @return the remark
	 */
	public final String getRemark()
	{
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public final void setRemark(String remark)
	{
		this.remark = remark;
	}

	/**
	 * @return the createDateTime
	 */
	public final Date getCreateDateTime()
	{
		return createDateTime;
	}

	/**
	 * @param createDateTime the createDateTime to set
	 */
	public final void setCreateDateTime(Date createDateTime)
	{
		this.createDateTime = createDateTime;
	}

	/**
	 * @return the updateDateTime
	 */
	public final Date getUpdateDateTime()
	{
		return updateDateTime;
	}

	/**
	 * @param updateDateTime the updateDateTime to set
	 */
	public final void setUpdateDateTime(Date updateDateTime)
	{
		this.updateDateTime = updateDateTime;
	}	
}
