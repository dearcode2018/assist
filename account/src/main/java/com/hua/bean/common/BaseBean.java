/**
  * @filename BaseBean.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.bean.common;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hua.serializer.DateTimeSerializer;

 /**
 * @type BaseBean
 * @description 基本 Bean
 * @author qianye.zheng
 */
public abstract class BaseBean implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	/* 对象唯一id，使用自增长 */
	private Integer id;

	/* 状态: 有效-1，无效-0 */
	private Integer status;
	
	private String statusName= "有效";
	
	/* 完整的备注 */
	private String remark;
	
	/* 短备注，限制10个字符 */
	private String shortRemark = "aa";
	
	/* 创建时间 */
	private Date createDateTime;
	
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
	 @JsonSerialize(using = DateTimeSerializer.class)
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
	 @JsonSerialize(using = DateTimeSerializer.class)
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

	/**
	 * @return the statusName
	 */
	public final String getStatusName()
	{
		// 状态: 有效-1，无效-0
		if (1 == status)
		{
			statusName = "有效";
		} else
		{
			statusName = "无效";
		}
		return statusName;
	}

	/**
	 * @param statusName the statusName to set
	 */
	public final void setStatusName(String statusName)
	{
		this.statusName = statusName;
	}

	/**
	 * @return the shortRemark
	 */
	public final String getShortRemark()
	{
		return shortRemark;
	}

	/**
	 * @param shortRemark the shortRemark to set
	 */
	public final void setShortRemark(String shortRemark)
	{
		this.shortRemark = shortRemark;
	}
	
}
