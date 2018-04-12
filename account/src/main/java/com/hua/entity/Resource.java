/**
  * @filename Resource.java
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
 * @type Resource
 * @description 资源
 * @author qianye.zheng
 */
@Entity(name = "t_resource")
//@Table(name = "t_resource")
public final class Resource
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
	
	@Column(name = "name", insertable = true, 
			updatable = true, length = 256, 
			nullable = true, unique = false)
	/* 资源名称 */
	private String name;
	
	@Column(name = "type", insertable = true, 
			updatable = true, length = 10, 
			nullable = true, unique = false)
	/* 资源类型 */
	private String type;
	
	@Column(name = "ownerId", insertable = true, 
			updatable = false, length = 11, 
			nullable = true, unique = false)
	/* 资源所有者id */
	private Integer ownerId;
	
	@Column(name = "title", insertable = true, 
			updatable = true, length = 64, 
			nullable = true, unique = false)
	/* 资源标题 */
	private String title;
	
	@Column(name = "path", insertable = true, 
			updatable = true, length = 512, 
			nullable = true, unique = false)
	/* 资源路径 */
	private String path;

	/**
	 * @return the name
	 */
	public final String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(String name)
	{
		this.name = name;
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
	 * @return the ownerId
	 */
	public final Integer getOwnerId()
	{
		return ownerId;
	}

	/**
	 * @param ownerId the ownerId to set
	 */
	public final void setOwnerId(Integer ownerId)
	{
		this.ownerId = ownerId;
	}

	/**
	 * @return the title
	 */
	public final String getTitle()
	{
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public final void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * @return the path
	 */
	public final String getPath()
	{
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public final void setPath(String path)
	{
		this.path = path;
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
