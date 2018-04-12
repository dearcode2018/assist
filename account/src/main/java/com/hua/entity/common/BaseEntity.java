/**
 * 描述: 
 * BaseEntity.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.entity.common;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @type BaseEntity
 * @description  
 * @author qianye.zheng
 */
public abstract class BaseEntity {
	
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
	private Integer status;
	
	@Column(name = "remark", insertable = true, 
			updatable = true, length = 1024, 
			nullable = true, unique = false)
	/* 备注 */
	private String remark;
	
	@Column(name = "createDateTime", insertable = true, 
			updatable = true,
			nullable = true, unique = false)
	/* 创建时间 */
	private Date createDateTime;
	
	@Column(name = "updateDateTime", insertable = true, 
			updatable = true,
			nullable = true, unique = false)
	/* 更新时间 */
	private Date updateDateTime;

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
